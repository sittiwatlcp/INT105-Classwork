/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INT105
 */
import base.*;
import peeking.*;

public class Test {

    public static void main(String[] args) {
        //testStudentList();
        //testStringList();
        //testGenericListString();
        //testGenericListStudent();
        //testCondition();
        testStudentCondition();
    }

    public static void testCondition() {
        Condition<String> longString = (String t) -> {
            if (t == null) {
                throw new IllegalArgumentException();
            }
            return t.length() > 10;
        };
        System.out.println(longString.test("I am Groot."));
        System.out.println(longString.test("I am."));

    }

    public static void testStudentCondition() {
        GenericList<Student> slist = new GenericList<>();
        slist.add(new Student(1, "A"));
        slist.add(new Student(2, "B"));
        slist.add(new Student(3, "C"));
        slist.add(new Student(4, "D"));
        slist.add(new Student(5, "E"));
        
        Condition<Student> c = new Condition<Student>() {
            @Override
            public boolean test(Student t) {
                return t.getId() == 3;
            }
            
        };
        System.out.println(slist.search(c));
    }

    public static void testStudentList() {
        Student s1 = new Student(1, "A");
        Student s2 = new Student(2, "B");
        Student s3 = new Student(3, "C");
        Student s4 = new Student(4, "D");
        StudentList slist = new StudentList();
        slist.add(s1);
        slist.add(s2);
        slist.add(s3);
        slist.add(s4);

        listing(slist);
    }

    public static void testStringList() {
        StringList slist = new StringList();
        slist.add("One");
        slist.add("Two");
        slist.add("Three");
        slist.add("Four");

        listing(slist);
    }

    public static void testGenericListString() {
        GenericList<String> slist = new GenericList();
        slist.add("One");
        slist.add("Two");
        slist.add("Three");
        slist.add("Four");

        listing(slist);
    }

    public static void testGenericListStudent() {
        Student s1 = new Student(1, "A");
        Student s2 = new Student(2, "B");
        Student s3 = new Student(3, "C");
        Student s4 = new Student(4, "D");
        GenericList<Student> slist = new GenericList();
        slist.add(s1);
        slist.add(s2);
        slist.add(s3);
        slist.add(s4);

        listing(slist);
    }

    public static <T> void listing(PeekableIterable<T> s) {
        PeekableIterator<T> it = s.iterator();
        while (it.hasNext()) {
            System.out.println("Student : " + it.peek());
            System.out.println("Student : " + it.next());

        }
    }
}
