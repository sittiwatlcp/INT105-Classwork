package int105generic._readmefirst;

/*
Problem:

1. Create a generic interface named Bag<T> that an object of type T can be added, 
searched, and removed from the store.  It keeps track of the number of objects 
of type T in the bag. Objects in the bag are unorganized. That is, there is 
no first object, second object, or last object.  Every object in the bag is 
just an object. They can even be duplicated depending on the implementation. 
Bag<T> also provides iterator for iterating over all objects of type T in the bag.

2. Write a javadoc for this interface.

สร้าง generic interface ชื่อ Bag<T> ซึ่งสามารถ จัดเก็บ ค้นหา และ ลบ Object ของ class T ได้ 
Bag จดจำจำนวนของ Object T ที่มีอยู่ใน Bag แต่ Object T ใน Bag ไม่มีการจัดระเบียบ 
นั่นคือ ไม่มีคำว่า Object แรก หรือ Object สุดท้าย ทุก Object ใน Bag ก็คือ หนึ่ง Object เช่นเดียวกัน
ทั้งนี้ ใน Bag ก็อาจมี Object ที่ซ้ำซ้อนกันได้ แล้วแต่แต่ละ implementation
Bag<T> มี iterator สำหรับเข้าถึงข้อมูลทุกตัวในที่มีอยู่ใน Bag
 */
public interface Bag<T> extends Iterable<T> {

    /* 
    If t is null, throw NullPointerException.
    Otherwise, return true if t is successfully added into in the bag 
    or return false if t cannot be added into the bag.
     */
    public boolean add(T t);

    /*
    If t is null, throw NullPointerException.
    Return true if t is successfully removed from the bag.
    Return false if t is not in the bag.
    In case that there are duplicate objects, 
    only one of them should be removed.
    However, it may depend on each implementation.
     */
    public boolean remove(T t);
 
    /*
    If t is null, throw NullPointerException.
    Return true if the bag contains object t; otherwise return false.
     */
   public boolean contains(T t);

    /*
    return the number of object T stored in the bag.
     */
    public int size();
}
