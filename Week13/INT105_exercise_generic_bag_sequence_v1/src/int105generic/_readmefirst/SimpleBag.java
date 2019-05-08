package int105generic._readmefirst;

/*
Problem:
(Prerequisite: create the Bag<T> interface)

Create SimpleBag<T> class that implements Bag<T> interface.
Duplicate objects can be added. When an object is removed, if there are 
multiple copies of the object, only one of them is removed.
It provides an iterator that supports remove operation.
When remove() is called via the iterator, it can be called only once 
after each call of next() via the iterator.

SimpleBag<T> has a private variable of type array of T for storing objects 
of type T and a private variable of type int for counting the number of object 
in the array. If the array is full, SimpleBag<T> (using reorganize() method) 
creates a new array to replace the old one and move all objects in the old array 
to the new one.  The new array should be twice as large as the old one. 
When an object is removed from the bag, the last object in the array should be moved 
to fill that empty slot so that the array is filled from the beginning of the array.
 */
import java.util.Iterator;

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
        // initialize the member varialbes with default values
        // set the default array size to 8
    }

    /**
     * constructor
     *
     * @param size the initial capacity to store objects
     * @throws IllegalArgumentException if size is less than 1
     */
    public SimpleBag(int size) {
        // initialize the member variables
        // set the initial size of the array to "size"
    }

    /**
     * add object t into the bag. Do not check if the object has already been in
     * the bag.
     *
     * @param t the object to be added
     * @return t if it is successfully added; otherwise return null.
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean add(T t) {
        // if "contents" array is full, call reorganize() to relocate objects.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void reorganize() {
        /* creates a new array to replace the old one and move all objects 
        in the old array to the new one.  The new array should be 
        twice as large as the old one. */
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * the number of objects in the bag.
     *
     * @return the number of objects in the bag.
     */
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * the iterator for the bag that supports remove operation
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
