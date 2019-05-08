package int105generic.solution;

/**
 * Bag<T> interface is a generic interface for an unordered collection of object
 * typed T. Object of type T in the bag can be added, removed, or searched.
 * Duplication of objects in the bag may or may not be allowed depending on the
 * implementation.
 * 
 * @author INT105
 * @param <T>
 */
public interface Bag<T> extends Iterable<T> {

    /**
     * add an object of type T into the bag.
     *
     * @param t the object to be added.
     * @return true if the operation succeeds; or false if the operation fails.
     * @throws NullPointerException if t is null
     * @throws IllegalStateException if the bag is full in case that the bag has
     * a limited capacity.
     */
    boolean add(T t);

    /**
     * remove the object t from the bag
     *
     * @param t the object to be removed.
     * @return true if the object t is successfully removed from the bag; or false
     * if the object t is not in the bag.
     * @throws NullPointerException if t is null
     */
    boolean remove(T t);

    /**
     * check if the object t is in the bag
     *
     * @param t the object to be searched
     * @return true if t is in the bag; or false if t is not in the bag.
     * @throws NullPointerException if t is null
     */
    boolean contains(T t);

    /**
     * the number of objects in the bag
     *
     * @return the number of objects in the bag.
     */
    int size();
}
