package int105generic.solution;

import int105generic.util.Condition;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NormalSequence<T extends Comparable<T>> implements Sequence<T> {

    private T[] contents; // the array for storing objects of type T
    private int tail; // the position to put the newly added object into the sequence 
    private int count; // the number of object of type T in the sequence
    protected int modCount; // used to invalidate iterators
    Condition<T> condition; // condition for adding objects into the sequence

    /**
     * constructor
     *
     * @param size the initial size of the sequence
     * @param condition the condition for adding objects into the sequence
     * @throws IllegalArgumentException if size < 1 or condition is null
     */
    public NormalSequence(int size, Condition<T> condition) {
        if (size < 1 || condition == null) {
            throw new IllegalArgumentException();
        }
        this.condition = condition;
        contents = (T[]) new Comparable[size];
    }

    /**
     * constructor: default condition is anything can be added into the sequence
     *
     * @param size the initial size of the sequence
     * @throws IllegalArgumentException if size < 1 or condition is null
     */
    public NormalSequence(int size) {
        this(size, Condition.alwaysTrue());
    }

    /**
     * constructor
     *
     * @param condition the condition for adding objects into the sequence
     * @throws IllegalArgumentException if size < 1 or condition is null
     */
    public NormalSequence(Condition<T> condition) {
        this(8, condition);
    }

    /**
     * constructor: default condition is anything can be added into the sequence
     */
    public NormalSequence() {
        this(Condition.alwaysTrue());
    }

    /**
     * the number of objects T in the sequence
     *
     * @return the number of objects T in the sequence
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * add object t into the sequence if t meets the condition
     *
     * @param t the object to be added into the sequence
     * @return true if added successfully; otherwise return false
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean add(T t) {
        if (condition.testNot(Objects.requireNonNull(t))) {
            return false;
        }
        if (tail == contents.length) {
            reorganize();
        }
        contents[tail++] = t;
        count++;
        modCount++;
        return true;
    }

    private void reorganize() {
        int newLength = count << 1;
        if (newLength < contents.length) {
            newLength = contents.length;
        }
        T[] newContents = (T[]) new Comparable[newLength];
        for (int i = 0, j = 0; i < tail; i++) {
            if (contents[i] == null) {
                continue;
            }
            newContents[j++] = contents[i];
        }
        contents = newContents;
        tail = count;
    }

    /**
     * remove object t from the sequence
     *
     * @param t the object to be removed from the sequence
     * @return true if removed successfully; otherwise return false
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean remove(T t) {
        return remove(Condition.isEqual(t)) != null;
    }

    /**
     * check if object t is in the sequence
     *
     * @param t the object to be check if it is in the sequence
     * @return true if found; otherwise return false
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean contains(T t) {
        return contains(Condition.isEqual(t)) != null;
    }

    /**
     * remove an object in the sequence that meets the condition c
     *
     * @param c the condition to remove an object
     * @return the object that meets the condition; return false if not found
     * @throws NullPointerException if c is null
     */
    @Override
    public T remove(Condition<T> c) {
        Objects.requireNonNull(c);
        for (int i = 0; i < tail; i++) {
            if (contents[i] == null || c.testNot(contents[i])) {
                continue;
            }
            T t = contents[i];
            contents[i] = null;
            count--;
            modCount++;
            return t;
        }
        return null;
    }

    /**
     * check if there is any object in the sequence that meets the condition c
     *
     * @param c the condition to search for an object
     * @return the object that meets the condition; return false if not found
     * @throws NullPointerException if c is null
     */
    @Override
    public T contains(Condition<T> c) {
        Objects.requireNonNull(c);
        for (int i = 0; i < tail; i++) {
            if (contents[i] != null && c.test(contents[i])) {
                return contents[i];
            }
        }
        return null;
    }

    /**
     * remove all objects in the sequence that meet the condition c
     *
     * @param c the condition to remove objects
     * @return a sequence of objects that meet the condition; or an empty
     * sequence if not found
     * @throws NullPointerException if c is null
     */
    @Override
    public Sequence<T> removeAll(Condition<T> c) {
        Objects.requireNonNull(c);
        Sequence<T> s = new NormalSequence<>();
        for (int i = 0; i < tail; i++) {
            if (contents[i] != null && c.test(contents[i])) {
                s.add(contents[i]);
                contents[i] = null;
                count--;
            }
        }
        modCount++;
        return s;
    }

    /**
     * find all objects in the sequence that meet the condition c
     *
     * @param c the condition to search for objects
     * @return a sequence of objects that meet the condition; or an empty
     * sequence if not found
     * @throws NullPointerException if c is null
     */
    @Override
    public Sequence<T> allContains(Condition<T> c) {
        Objects.requireNonNull(c);
        Sequence<T> s = new NormalSequence<>();
        for (int i = 0; i < tail; i++) {
            if (contents[i] != null && c.test(contents[i])) {
                s.add(contents[i]);
            }
        }
        return s;
    }

    /**
     * sort objects in the sequence using the provided comparator
     *
     * @param c the comparator for sorting the objects in the sequence
     * @throws NullPointerException if c is null
     */
    @Override
    public void sort(Comparator<T> c) {
        Arrays.sort(contents, Comparator.nullsLast(Objects.requireNonNull(c)));
        tail = count;
        modCount++;
    }

    /**
     * fail-fast iterator for the sequence
     *
     * @return iterator that supports remove operation
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            /*
            use cursor to remember the position that it iterates in the sequence.
             */
            private int cursor;

            /*
            Use "removable" flag to prevent consecutive call to iterator.remove().
             */
            private boolean removable = false;

            /*
            Use "modCount" to invalidate this iterator if the sequence get changed 
            after this iterator has been created (by comparing the "modCount" value).
             */
            private int modCount = NormalSequence.this.modCount;

            private void validate() {
                if (modCount != NormalSequence.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                validate();
                while (cursor < tail && contents[cursor] == null) {
                    cursor++;
                }
                return contents[cursor] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                removable = true;
                return contents[cursor++];
            }

            @Override
            public void remove() {
                validate();
                if (!removable) {
                    throw new IllegalStateException();
                }
                NormalSequence.this.remove(contents[cursor - 1]);
                removable = false;
                modCount++;
            }

        };
    }

    @Override
    public Iterator<T> iterator(Condition<T> c) {
        return new Iterator<T>() {

            /*
            the condition for iteration
             */
            private Condition<T> cond = c;

            /*
            use cursor to remember the position that it iterates in the sequence.
             */
            private int cursor;

            private int current;

            /*
            Use "removable" flag to prevent consecutive call to iterator.remove().
             */
            private boolean removable = false;

            /*
            Use "modCount" to invalidate this iterator if the sequence get changed 
            after this iterator has been created (by comparing the "modCount" value).
             */
            private int modCount = NormalSequence.this.modCount;

            /* 
            non-static block for getting the first object that meets the condition
             */
            {
                lookAhead();
            }

            /* to make sure that the sequence has not changed */
            private void validate() {
                if (modCount != NormalSequence.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            /*
            find an object that meets the condition 
             */
            private void lookAhead() {
                while (cursor < tail
                        && (contents[cursor] == null
                        || cond.testNot(contents[cursor]))) {
                    cursor++;
                }
            }

            @Override
            public boolean hasNext() {
                validate();
                return cursor < tail;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                removable = true;
                current = cursor++;
                lookAhead();
                return contents[current];
            }

            @Override
            public void remove() {
                validate();
                if (!removable) {
                    throw new IllegalStateException();
                }
                contents[current] = null;
                removable = false;
                count--;
                modCount++;
                NormalSequence.this.modCount++;
            }

        };
    }

}
