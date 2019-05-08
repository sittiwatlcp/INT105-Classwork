Problems:

Problem 1. Bag<T> interface extends Iterable<T>

Create a generic interface named Bag<T> that an object of type T can be added, 
searched, and removed from the bag.  It keeps track of the number of objects 
of type T in the bag. Objects in the bag are unorganized. That is, there is 
no first object, second object, or last object.  Every object in the bag is 
just an object. They can even be duplicated depending on the implementation. 
Bag<T> also provides iterator for iterating over all objects of type T in the bag.
Write a javadoc for this interface too.

สร้าง generic interface ชื่อ Bag<T> ซึ่งสามารถ จัดเก็บ ค้นหา และ ลบ Object ของ class T ได้ 
Bag จดจำจำนวนของ Object T ที่มีอยู่ใน Bag แต่ Object T ใน Bag ไม่มีการจัดระเบียบ 
นั่นคือ ไม่มีคำว่า Object แรก หรือ Object สุดท้าย ทุก Object ใน Bag ก็คือ หนึ่ง Object เช่นเดียวกัน
ทั้งนี้ ใน Bag ก็อาจมี Object ที่ซ้ำซ้อนกันได้ แล้วแต่แต่ละ implementation
Bag<T> มี iterator สำหรับเข้าถึงข้อมูลทุกตัวในที่มีอยู่ใน Bag

-------------------------------------------------------------------------
Problem 2. SimpleBag<T> class implements Bag<T> 
Prerequisite: Problem 1.

Create SimpleBag<T> class that implements Bag<T> interface.
Duplicate objects can be added. When an object is removed, 
if there are multiple copies of the object, only one of them is removed.
It provides an iterator that supports remove operation.
When remove() is called via the iterator, it can be called only once 
after each call of next() via the iterator.

SimpleBag<T> has a private variable of type array of T for storing objects 
of type T and a private variable of type int for counting the number of object 
in the array. If the array is full, SimpleBag<T> (using reorganize() method) 
creates a new array to replace the old one and move all objects in the old array 
to the new one.  The new array should be twice as large as the old one. 
When an object is removed from the bag, the last object in the array should be moved 
to fill that empty slot so that the array is filled from the beginning of the array.

-------------------------------------------------------------------------
Problem 3. SimpleBagTest class
Prerequisite: Problem 2.

Create SimpleBagTest class to test the correctness of Bag<T> and SimpleBag<T>.
Create an object of type SimpleBag<String> and test all of the following methods:
SimpleBag(), SimpleBag(size), add(t), remove(t), contains(t), size(), iterator(),
and all iterator's methods: hasNext(), next(), and remove().

-------------------------------------------------------------------------
Problem 4. StandardBag<T> class extends SimpleBag<T>
Prerequisite: Problem 2.

Create StardardBag<T> that extends SimpleBag<T> in order to correct the behavior 
of the iterator. SimpleBag's iterator is neither fail-fast nor fail-safe.
Fail-fast iterators are iterators that stop working if the collections that 
they iterate change structurally (unless the changes are done through 
the iterators themselves). Fail-safe iterators are iterators that work 
on copies of the collections that they want to iterate. So, Fail-safe iterators 
actually work on old versions of the collections. Search the web for 
more information on this issue. Implementing StandardBag<T> by extending 
SimpleBag<T> to support fail-fast iterators.

-------------------------------------------------------------------------
Problem 5. StandardBagTest class
Prerequisite: Problem 4.
Should have done: Problem 3.

Create StandardBagTest class to test the correctness of StandardBag<T>, 
especially, the behavior of StandardBag<T>'s iterator.

=========================================================================
Problem 6X. Study Condition<T> interface 
in int105generic.util and int105generic.util.example package

1. study how to write and use default methods: 
    testNot(T t), not(), and(Condition<T> c), or(Condition<T> c)

2. study how to write and use static generic methods:
    isEqual(T o), alwaysTrue(), alwaysFalse()

   Observe that static generic methods have <T> in front of the return type.

3. study how to write and use methods with variable arguments (varargs ...):
    andAll(Condition<T> ... conditions), orAll(Condition<T> ... conditions)

    Observe that if a parameter of a method is defined with ... notation, 
    it means that that parameter is in fact an array of that type.
    That is, "methodA(double d, int ... i)" means "methodA(double d, int[] i)".
    It can be called like "methodA(10.5, 4, 8, 6)" and i will be [4, 8, 6].
    Only the last parameter of the method can be defined with ... notation.

-------------------------------------------------------------------------
Problem 6. ConditionalBag<T> interface extends Bag<T> interface
Prerequisite: Problem 1, 6X.

Create ConditionalBag<T> that extends Bag<T> interface. 
ConditionalBag allows to remove objects of type T based on a specified condition.
If there are multiple objects of type T that can pass the condition, 
only one of them should be removed from the bag.

-------------------------------------------------------------------------
Problem 7. ComplexBag<T> class extends StandardBag<T> class 
and implements ConditionalBag<T>
Prerequisite: Problem 4, 6.

Create ComplexBag<T> that extends StandardBag<T> and implements ConditionalBag<T>. 
ComplexBag allows to add only objects of type T that pass a certain condition.
Each ComplexBag has a fix condition for addition that can never change. 
ComplexBag allows to search and remove objects of type T that meets a specified condition.

-------------------------------------------------------------------------
Problem 8. ComplexBagTest class
Prerequisite: Problem 6, 7.
Should have done: Problem 3, 5.

Create ComplexBagTest class to test the correctness of ComplexBag<T>.
Especially, remove(Condition<T>) and contains(Condition<T>).

=========================================================================
Problem 9. Sequence<T> interface extends ConditionalBag<T> interface
Prerequisite: Problem 6.

Sequence<T> is like ConditionalBag<T> except that Sequence<T> preserves the order of objects 
of type T in the sequence and it also supports a sort function on the sequence 
based on the natural order of T.  That also means that T must implement Comparable<T>.

-------------------------------------------------------------------------
Problem 10. NormalSequence<T> class implements Sequence<T> interface
Prerequisite: Problem 2, 4, 6, 8, 9.

Create NormalSequence<T> class that preserves the order of objects of type T 
that are inserted into the sequence.  NormalSequence supports conditional addition 
and conditional remove operation like ComplexBag. NormalSequence supports 
fail-fast iterators that support remove operation.

-------------------------------------------------------------------------
Problem 11. NormalSequenceTest class 
Prerequisite: Problem 10.
Should have done: Problem 3, 5, 8.

Create NormalSequenceTest class to test the correctness of NormalSequence<T>.

=========================================================================
