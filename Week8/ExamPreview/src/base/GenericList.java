/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import peeking.PeekableIterable;
import peeking.PeekableIterator;

/**
 *
 * @author INT105
 */
public class GenericList<T> implements PeekableIterable<T>{

    T[] list;
    int count;

    public GenericList() {
        this(8);
    }
    
    public GenericList(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("StudentList's size must be larger than 0.");
        }
        this.list = (T[]) new Object[size];

    }

    public boolean add(T s) {
        if (s == null || count == this.list.length) {
            return false;
        }
        list[count++] = s;
        return true;
    }

    @Override
    public PeekableIterator<T> iterator() {
        return new PeekableIterator<T>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index != count;
            }

            @Override
            public T next() {
                if (index == count) {
                    throw new IllegalStateException("No more element.");
                }
                return list[index++];
            }

            @Override
            public T peek() {
                if (index == count) {
                    throw new IllegalStateException("No more element.");
                }
                return list[index];
            }
            
            
        };
        
    }

}
