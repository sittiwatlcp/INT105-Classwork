/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105midtermexercise;

import java.util.Objects;

/**
 *
 * @author INT105
 */
class Student  {

    private final int id;
    private final String name;
    private final double gpax;

    public Student(int id, String name, double gpax) {
        //if(name == null) throw new NullPointerException("Student name can't be null");
        Objects.requireNonNull(name, "Student name can't be null");
        this.id = id;
        this.name = name;
        this.gpax = gpax;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gpax=" + gpax + '}';
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpax() {
        return gpax;
    }

    public static Condition<Student> hornor() {
        return (Student t) -> t.getGpax() >= 3.0;
    }
    
    public static Condition<Student> pro() {
        return (Student t) -> t.getGpax() < 2.0;
    }
    
    public static Condition<Student> nameContains(String s) {
        Objects.requireNonNull(s);
        return (Student t) -> t.name.contains(s);
    }
}
