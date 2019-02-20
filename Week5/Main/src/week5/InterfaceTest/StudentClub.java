/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.InterfaceTest;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author INT105
 */
public class StudentClub implements Iterable<Student>{

    Student[] students;
    int size;
    int index;

    public StudentClub() {
        students = new Student[10];
        this.size = 0;
        this.index = -1;
    }

    public boolean add(Student s) {
        boolean add = false;
        if (size == 10 || s == null) {
            return false;
        }
        students[size++] = s;
        return add;
    }
    public boolean hasNext() {
        if (index > 0) {
            return true;
        }
        return false;
    }

    public Student next(){
        if (this.index<this.size) {
            return students[this.index];
        }
        return null;
    }
    public void reset() {
        if (this.size > 0) {
            this.index = 0;
        }
    }

    @Override
    public Iterator<Student> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
