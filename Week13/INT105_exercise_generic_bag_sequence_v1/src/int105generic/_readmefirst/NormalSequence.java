package int105generic._readmefirst;

import int105generic.util.Condition;
import java.util.Comparator;
import java.util.Iterator;

/*
Problem:

Create NormalSequence<T> class that preserves the order of objects of type T 
that are inserted into the sequence.  NormalSequence supports conditional addition 
and conditional remove operation like ComplexBag. NormalSequence supports 
fail-fast iterators that support remove operation.
*/
public class NormalSequence<T> {

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
        // your code
    }

    /**
     * constructor: default condition is anything can be added into the sequence
     *
     * @param size the initial size of the sequence
     * @throws IllegalArgumentException if size < 1 or condition is null
     */
    public NormalSequence(int size) {
        // your code
    }

    /**
     * constructor
     *
     * @param condition the condition for adding objects into the sequence
     * @throws IllegalArgumentException if size < 1 or condition is null
     */
    public NormalSequence(Condition<T> condition) {
        // your code
    }

    /**
     * constructor: default condition is anything can be added into the sequence
     */
    public NormalSequence() {
        // your code
    }

    /**
     * the number of objects T in the sequence
     *
     * @return the number of objects T in the sequence
     */
    public int size() {
        // your code
        return 0;
    }

    /**
     * add object t into the sequence if t meets the condition
     *
     * @param t the object to be added into the sequence
     * @return true if added successfully; otherwise return false
     * @throws NullPointerException if t is null
     */
    public boolean add(T t) {
        // your code
        return false;
    }

    /**
     * remove object t from the sequence
     *
     * @param t the object to be removed from the sequence
     * @return true if removed successfully; otherwise return false
     * @throws NullPointerException if t is null
     */
    public boolean remove(T t) {
        // your code
        return false;
    }

    /**
     * check if object t is in the sequence
     *
     * @param t the object to be check if it is in the sequence
     * @return true if found; otherwise return false
     * @throws NullPointerException if t is null
     */
    public boolean contains(T t) {
        // your code
        return false;
    }

    /**
     * remove an object in the sequence that meets the condition c
     *
     * @param c the condition to remove an object
     * @return the object that meets the condition; return false if not found
     * @throws NullPointerException if c is null
     */
    public T remove(Condition<T> c) {
        // your code
        return null;
    }

    /**
     * check if there is any object in the sequence that meets the condition c
     *
     * @param c the condition to search for an object
     * @return the object that meets the condition; return false if not found
     * @throws NullPointerException if c is null
     */
    public T contains(Condition<T> c) {
        // your code
        return null;
    }

    /**
     * sort objects in the sequence using the provided comparator
     *
     * @param c the comparator for sorting the objects in the sequence
     * @throws NullPointerException if c is null
     */
    public void sort(Comparator<T> c) {
        // your code
    }

    /**
     * fail-fast iterator for the sequence
     *
     * @return iterator that supports remove operation
     */
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

            @Override
            public boolean hasNext() {
                // your code
                return false;
            }

            @Override
            public T next() {
                // your code
                return null;
            }

            @Override
            public void remove() {
                // your code
            }
        };
    }
}
