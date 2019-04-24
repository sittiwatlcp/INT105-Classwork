package int105.student;


import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class StudentClub implements Iterator<Student>{
    Student students[];
    int index;
    int size;
    public StudentClub(){
        students=new Student[10];
        size=0;
        index=0;
    }

    public boolean add(Student s){
        if(s==null)
            return false;
        if(size==students.length){
            Student[] tmp = new Student[size+10];
            System.arraycopy(students, 0, tmp, 0, size);
            students = tmp;
        }
            
        students[size++]=s;
        return true;
    }
    
    @Override
    public boolean hasNext() {
       if(index==size)
           return false;
       
       return true;
    }

    @Override
    public Student next() {
       if(index<size)
        return students[index++];
       throw new NoSuchElementException("You Should Reset");
     }

    @Override
    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void reset(){
        if(size>0)
            index=0;
    }
    
    public int size(){
        return size;
    }
}
