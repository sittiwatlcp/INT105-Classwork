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
public class StudentList implements PeekableIterable<Student>{

    Student[] list;
    int count;

    public StudentList() {
        this(8);
    }
    
    public StudentList(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("StudentList's size must be larger than 0.");
        }
        this.list = new Student[size];

    }

    public boolean add(Student s) {
        if (s == null || count == this.list.length) {
            return false;
        }
        list[count++] = s;
        return true;
    }

    @Override
    public PeekableIterator<Student> iterator() {
        return new PeekableIterator<Student>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index != count;
            }

            @Override
            public Student next() {
                if (index == count) {
                    throw new IllegalStateException("No more element.");
                }
                return list[index++];
            }

            @Override
            public Student peek() {
                if (index == count) {
                    throw new IllegalStateException("No more element.");
                }
                return list[index];
            }
            
            
        };
        
    }

}
