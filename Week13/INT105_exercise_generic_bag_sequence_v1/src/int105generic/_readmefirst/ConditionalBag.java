package int105generic._readmefirst;

import int105generic.util.Condition;

/*
Problem:

Create a generic interface named ConditionalBag<T> that extends Bag<T>.
It extends five methods: remove(Condition<T>), contains(Condition<T>), 
removeAll(Condition<T>), allContains(Condition<T>), and iterator(Condition<T>) 
that receive Condition<T> as arguments. 
- remove(Condition<T>) should remove and return the object that meets the condition. 
- contains(Condition<T>) should find and return the object that meets the condition. 
In case that they cannot find the object that meets the condition, both methods return null.
- removeAll(Condition<T>) should remove and return all objects that meet the condition. 
- allContains(Condition<T>) should find and return all objects that meet the condition. 
In case that they cannot find objects that meet the condition, both methods return an empty Bag.
- iterator(Condition<T>) return a fail-fast iterator that should support remove operation 
and this iterator iterate over the bag of objects that meet the condition only
*/
public interface ConditionalBag<T> extends Bag<T> {
    
    /**
     * remove an object of type T that meets the condition c from the bag
     * 
     * @param c the condition that is used to find the object
     * @return an object of type T that meets the condition c; or null if not found
     * @throws NullPointerException if c is null
     */
    // write your method signature for remove() here 
    
    /**
     * find an object of type T that meets the condition c in the bag
     * 
     * @param c the condition that is used to find the object
     * @return an object of type T that meets the condition c; or null if not found.
     * @throws NullPointerException if c is null
     */
    // write your method signature for contains() here

    /**
     * remove all objects of type T that meet the condition c from the bag
     * 
     * @param c the condition that is used to find the object
     * @return a Bag of objects of type T that meets the condition c; or an empty Bag if not found
     * @throws NullPointerException if c is null
     */
    // write your method signature for removeAll() here 
    
    /**
     * find all objects of type T that meet the condition c in the bag
     * 
     * @param c the condition that is used to find the object
     * @return a Bag of objects of type T that meet the condition c; or an empty Bag if not found.
     * @throws NullPointerException if c is null
     */
    // write your method signature for allContains() here

     /**
     * a fail-fast iterator that can iterate over the bag of objects 
     * but skips objects that do not meet the condition
     * 
     * @param c the condition that is used to select the objects
     * @return the iterator that support remove operation
     * @throws NullPointerException if c is null
     */
    // write your method signature for iterator with Condition<T> here
}
