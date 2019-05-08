package int105generic._readmefirst;

import java.util.Comparator;

/*
Problem:

Sequence<T> is like ConditionalBag<T> except that Sequence<T> preserves the order of objects 
of type T in the sequence and it also supports a sort function on the sequence 
based on the natural order of T.  That also means that T must implement Comparable<T>.

Modify the header of Sequence<T> to make sure that it extends ConditionalBag<T> 
and T implements Comparable<T>.
*/

public interface Sequence<T> {
    
    /**
     * sort the objects in the sequence using the given comparator
     * 
     * @param c the comparator for sorting
     * @throws NullPointerException if c is null
     */
    void sort(Comparator<T> c);
    
    /**
     * sort the objects in the sequence using the natural order of T
     */
    default void sort() {
        // your code
    }
}
