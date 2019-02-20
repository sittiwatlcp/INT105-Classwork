/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.InterfaceTest;

/**
 *
 * @author INT105
 */
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean hasNext() {
        boolean hasNext = false;
        return false;
    }

    public Student next(){

        return null;
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }
    

     
}
