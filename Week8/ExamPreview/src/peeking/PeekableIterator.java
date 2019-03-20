/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peeking;

import java.util.Iterator;

/**
 *
 * @author INT105
 */
public interface PeekableIterator<T> extends Iterator<T>{
    default T peek(){
        throw new UnsupportedOperationException("Does not allow peek operation");
    }
}
