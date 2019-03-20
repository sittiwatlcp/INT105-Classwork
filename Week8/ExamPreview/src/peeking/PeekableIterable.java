/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peeking;

/**
 *
 * @author INT105
 */
public interface PeekableIterable<T> {
    PeekableIterator<T> iterator();
}
