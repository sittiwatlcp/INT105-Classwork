/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

import week5.InterfaceTest.Student;
import week5.InterfaceTest.StudentClub;

/**
 *
 * @author INT105
 */
public class Week5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testStudentClub();
    }

    public static void testStudentClub() {
        StudentClub s = new StudentClub();
        s.add(new Student(1, "A"));
        s.add(new Student(2, "B"));
        s.add(new Student(3, "C"));
        s.add(new Student(4, "D"));
        s.reset();
        Iterable<Student> i = s;
        try {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
            System.out.println(s.next());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(" something ");
    }

}
