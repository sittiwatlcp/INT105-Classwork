package int105generic.solution;

import int105generic.util.Condition;
import java.util.Iterator;

/**
 * ConditionalBag<T> interface is a generic interface that extends Bag<T>.
 * The added functionalities are the abilities to find and to remove 
 * an object of type T that meets a given condition.
 * 
 * @author INT105
 * @param <T> 
 */
public interface ConditionalBag<T> extends Bag<T> {
    
    /**
     * remove an object of type T that meets the condition c from the bag
     * 
     * @param c the condition that is used to find the object
     * @return an object of type T that meets the condition c; or null if not found
     * @throws NullPointerException if c is null
     */
    T remove(Condition<T> c);
    
    /**
     * find an object of type T that meets the condition c in the bag
     * 
     * @param c the condition that is used to find the object
     * @return an object of type T that meets the condition c; or null if not found.
     * @throws NullPointerException if c is null
     */
    T contains(Condition<T> c);
    
    /**
     * remove all objects of type T that meet the condition c from the bag
     * 
     * @param c the condition that is used to search for the objects
     * @return a Bag of all objects of type T that meet the condition c; 
     * or an empty Bag if not found
     * @throws NullPointerException if c is null
     */
    Bag<T> removeAll(Condition<T> c);
    
    /**
     * find all objects of type T that meet the condition c in the bag
     * 
     * @param c the condition that is used to find objects
     * @return a Bag of all objects of type T that meets the condition c; 
     * or an empty Bag if not found
     * @throws NullPointerException if c is null
     */
    Bag<T> allContains(Condition<T> c);
    
    /**
     * an iterator that iterates over the bag of objects of type T that meets 
     * a certain condition only
     * 
     * @param c the condition that is used to iterate over the bag of objects of type T
     * @return an iterator that will iterate over the bag of objects of type T 
     * that meets the condition c only
     * @throws NullPointerException if c is null
     */
    Iterator<T> iterator(Condition<T> c);
}
