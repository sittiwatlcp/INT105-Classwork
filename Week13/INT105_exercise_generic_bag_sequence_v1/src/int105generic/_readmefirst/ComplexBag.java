package int105generic._readmefirst;

import int105generic.util.Condition;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
Problem:

Create ComplexBag<T> that extends StandardBag<T> and implements ConditionalBag<T>. 
ComplexBag allows to add only objects of type T that pass a certain condition.
Each ComplexBag has a fix condition for addition that can never change. 
ComplexBag allows to search and remove objects of type T that meets a specified condition.
*/
public class ComplexBag<T> extends StandardBag<T> implements ConditionalBag<T> {

    /* the condition that is used to check before adding an object into the bag. */
    private Condition<T> condition; 

    public ComplexBag() {
        // your code
    }

    public ComplexBag(Condition<T> condition) {
        // your code
    }

    public ComplexBag(int size) {
        // your code
    }

    public ComplexBag(int size, Condition<T> condition) {
        // your code
    }

    /**
     * add object t into the bag. Only the object t that pass the condition can
     * be added. It does not check if the object has already been in the bag.
     *
     * @param t the object to be added
     * @return true if it is successfully added; otherwise return false.
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    /**
     * remove an object that pass the condition c from the bag. If there are
     * multiple objects that pass the condition, remove just one of them.
     *
     * @param c the condition that is used to remove object t from the bag
     * @return the object that can pass the condition; otherwise return null
     * @throws NullPointerException if c is null
     */
    public T remove(Condition<T> c) {
        // your code
        throw new UnsupportedOperationException();
    }

    /**
     * check if there is an object in the bag that can pass the condition. If
     * there are multiple objects that pass the condition, return just one of
     * them.
     *
     * @param c the condition that is used to search objects in the bag
     * @return the object that can pass the condition; otherwise return null
     * @throws NullPointerException if c is null
     */
    public T contains(Condition<T> c) {
        // your code
        throw new UnsupportedOperationException();
    }

    /**
     * remove all objects that meet the condition c from the bag.
     *
     * @param c the condition that is used to remove objects from the bag
     * @return a Bag of objects that are removed; otherwise return an empty Bag
     * @throws NullPointerException if c is null
     */
    // public Bag<T> removeAll(Condition<T> c) { }

    /**
     * find all objects of type T that meet the condition c in the bag
     *
     * @param c the condition that is used to search for the objects
     * @return a Bag of all objects of type T that meets the condition c; or an
     * empty Bag if not found
     * @throws NullPointerException if c is null
     */
    // public Bag<T> allContains(Condition<T> c) { }

    /**
     * an iterator that iterates over the bag of objects of type T that meets a
     * certain condition only
     *
     * @param c the condition that is used to iterate over the bag of objects of
     * type T
     * @return an iterator that will iterate over the bag of objects of type T
     * that meets the condition c only
     * @throws NullPointerException if c is null
     */
    // public Iterator<T> iterator(Condition<T> c) { }

}
