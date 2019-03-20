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
public class StringList implements PeekableIterable<String>{

    String[] list;
    int count;

    public StringList() {
        this(8);
    }
    
    public StringList(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("StudentList's size must be larger than 0.");
        }
        this.list = new String[size];

    }

    public boolean add(String s) {
        if (s == null || count == this.list.length) {
            return false;
        }
        list[count++] = s;
        return true;
    }

    @Override
    public PeekableIterator<String> iterator() {
        return new PeekableIterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index != count;
            }

            @Override
            public String next() {
                if (index == count) {
                    throw new IllegalStateException("No more element.");
                }
                return list[index++];
            }

            @Override
            public String peek() {
                if (index == count) {
                    throw new IllegalStateException("No more element.");
                }
                return list[index];
            }
            
            
        };
        
    }

}
