/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105midtermexercise;

/**
 *
 * @author INT105
 */
public interface NonNullList<T> extends Iterable<T> {

    boolean append(T t);

    T remove();

    default T peek(){ throw new UnsupportedOperationException();}

    default T[] toArray(){ throw new UnsupportedOperationException();}

    default int length(){ throw new UnsupportedOperationException();}

    default boolean contains(T t){ throw new UnsupportedOperationException();}

    default boolean remove(T t){ throw new UnsupportedOperationException();}

}
