/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105midtermexercise;

import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author INT105
 */
public class Int105midtermexercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testState();
        //testCondition();
        testSimpleList();
    }

    public static void testCondition() {
        Student[] studentList = new Student[4];
        studentList[0] = new Student(1, "Adam", 2.55);
        studentList[1] = new Student(2, "Carol", 1.93);
        studentList[2] = new Student(3, "Dole", 3.02);
        studentList[3] = new Student(4, "Brain", 3.25);
        for (Student student : studentList) {
//            if (Student.hornor().test(student)){
//                System.out.println("Hornor: " + student);
//            }
//            if (Student.pro().test(student)){
//                System.out.println("Pro: " + student);
//            }
//            if (Student.nameContains("a").test(student)){
//                System.out.println("has a: " + student);
//            }
//            if (Student.nameContains("a").testNot(student)){
//                System.out.println("no a : " + student);
//            }
            if (Student.nameContains("a").and(Student.hornor()).test(student)) {
                System.out.println("Hornor with 'a'" + student);
            }
        }
    }

    public static void testState() {
        State s1 = State.firstState();
        State nextState = s1.next();
        State nextState2 = nextState.next();

        System.out.println("next state of s1 is : " + nextState);
        System.out.println("next state of s1 2 is : " + nextState2);

        State s2 = State.firstState();
        System.out.println("s2 is empty or not : " + s2.isEmpty());
    }

    public static void testSimpleList() {
        SimpleList<Student> ssl = new SimpleList<Student>();
        Student s1 = new Student(1, "A", 3.0);
        Student s2 = new Student(2, "b", 2.5);
        Student s3 = new Student(3, "Dole", 3.02);
        Student s4 = new Student(4, "Brain", 3.25);

        ssl.append(s1);
        ssl.append(s2);
        ssl.append(s3);
        ssl.append(s4);

        ssl.remove();
        ssl.remove();

        int length = ssl.length();
        Iterator<Student> stdList = ssl.iterator();
        while (stdList.hasNext()) {
            System.out.println(stdList.next());
        }

    }

}
