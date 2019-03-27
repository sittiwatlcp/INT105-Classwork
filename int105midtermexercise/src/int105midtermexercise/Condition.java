/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105midtermexercise;

/**
 *
 * @author INT105
 */
public interface Condition<T> {

    public boolean test(T t);

    default boolean testNot(T t) {
        return test(t);
    }

    default Condition<T> and(Condition<T> c) {
        return (T t) -> Condition.this.test(t) && c.test(t);
    }
//    public default isEqual(T t);
//    public default and(T t);
//    public static Condition<T> andAll(T t);
//    public static Condition<T> not();
}
