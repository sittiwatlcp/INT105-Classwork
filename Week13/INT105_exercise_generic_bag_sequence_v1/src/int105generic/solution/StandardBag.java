package int105generic.solution;

import java.util.Iterator;
import java.util.ConcurrentModificationException;

/**
 * StandardBag<T> corrects the behavior of SimpleBag<T>'s iterator. StandardBag
 * provides fail-fast iterator instead of an iterator that behaves incorrectly
 * if the structure of the bag is modified.
 *
 * @author INT105
 * @param <T>
 */
public class StandardBag<T> extends SimpleBag<T> {

    /* count the number of times that 
    the bag is modified structurally. */
    protected int modCount;

    /**
     * constructor
     */
    public StandardBag() {
        // super(); // this line is called implicitly anyway.
    }

    /**
     * constructor
     *
     * @param size the initial capacity to store objects
     * @throws IllegalArgumentException if size is less than 1
     */
    public StandardBag(int size) {
        super(size);
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
        boolean result = super.add(t);
        if (result) {
            modCount++;
        }
        return result;
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
        boolean result = super.remove(t);
        if (result) {
            modCount++;
        }
        return result;
    }

    /**
     * fail-fast iterator for the bag that supports remove operation
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private Iterator<T> iterator = StandardBag.super.iterator();
            private int modCount = StandardBag.this.modCount;

            private void validate() {
                if (modCount != StandardBag.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
            
            @Override
            public boolean hasNext() {
                validate();
                return iterator.hasNext();
            }

            @Override
            public T next() {
                validate();
                return iterator.next();
            }

            @Override
            public void remove() {
                validate();
                iterator.remove();
                modCount++;
            }
        };
    }

}
