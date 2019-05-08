package int105generic.solution;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * SimpleBag<T> contains objects of type T. Objects can be added, removed, and
 * searched. Duplicate objects can be added. When an object is removed, if there
 * are multiple copies of the object, only one of them is removed.
 *
 * @author INT105
 * @param <T>
 */
public class SimpleBag<T> implements Bag<T> {

    private T[] contents; // storing objects of type T
    private int count; // counting the number of objects in the bag

    /**
     * constructor
     */
    public SimpleBag() {
        this(8);
    }

    /**
     * constructor
     *
     * @param size the initial capacity to store objects
     * @throws IllegalArgumentException if size is less than 1
     */
    public SimpleBag(int size) {
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        contents = (T[]) new Object[size];
    }

    /**
     * add object t into the bag. Do not check if the object has already been in
     * the bag.
     *
     * @param t the object to be added
     * @return true if it is successfully added; otherwise return false.
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean add(T t) {
        Objects.requireNonNull(t);
        if (count == contents.length) {
            reorganize();
        }
        contents[count++] = t;
        return true;
    }

    private void reorganize() {
        T[] newHome = (T[]) new Object[count << 1];
        //for (int i = 0; i < count; i++) newHome[i] = contents[i];
        System.arraycopy(contents, 0, newHome, 0, count);
        contents = newHome;
    }

    /**
     * remove object t from the bag. If there are duplicated objects, remove one
     * of them.
     *
     * @param t the object to be removed
     * @return true if t is successfully removed; or false if the object t is
     * not in the bag.
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean remove(T t) {
        Objects.requireNonNull(t);
        for (int i = 0; i < count; i++) {
            if (t.equals(contents[i])) {
                count--;
                contents[i] = contents[count];
                contents[count] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * search if an object is in the bag
     *
     * @param t the object to be searched
     * @return true if the bag contains t; otherwise false
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean contains(T t) {
        Objects.requireNonNull(t);
        for (int i = 0; i < count; i++) {
            if (t.equals(contents[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * the number of objects in the bag.
     *
     * @return the number of objects in the bag.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * the iterator for the bag that supports remove operation
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            /* From inside the inner class (Iterator<T>), 
            instance variables and instance methods of SimpleBag<T> 
            can be referenced as SimpleBag.this.variable_or_method_name, 
            e.g., "SimpleBag.this.count", "SimpleBag.this.size()".
            From inside the inner class, static variables and static methods 
            of SimpleBag<T> can be referenced as "SimpleBag.static_variable_name" 
            and "SimpleBag.static_method_name()" respectively. */

            private int cursor = 0;

            /* The removable flag is set to true when next() is called
            and it is set to false when remove() is called.
            This is to make sure that remove() can only be called once 
            after each next() is called. */
            private boolean removable = false;

            @Override
            public boolean hasNext() {
                // "count" is the same as "SimpleBag.this.count"
                return cursor < count;
            }

            @Override
            public T next() {

                if (cursor >= count) {
                    // "count" is the same as "SimpleBag.this.count"
                    throw new NoSuchElementException();
                }
                removable = true;
                
                // "contents" is the same as "SimpleBag.this.contents"
                return contents[cursor++];
            }

            @Override
            public void remove() {
                if (!removable) {
                    throw new IllegalStateException();
                }
                removable = false;
                
                // call remove() of SimpleBag
                SimpleBag.this.remove(contents[--cursor]);
            }
        };
    }

}
