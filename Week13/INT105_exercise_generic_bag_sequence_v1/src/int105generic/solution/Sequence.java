package int105generic.solution;

import java.util.Comparator;

/**
 * Sequence<T> interface is a generic interface that extends ConditionalBag<T>.
 * Sequence preserves the order of objects in the sequence.
 * 
 * @author INT105
 * @param <T> 
 */
public interface Sequence<T extends Comparable<T>> extends ConditionalBag<T> {
    
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
    default void sort() { sort(Comparator.naturalOrder()); }
}
