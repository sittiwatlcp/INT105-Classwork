package int105generic.util;

import java.util.Objects;

/**
 * Condition is for holding a particular state that something (T) is in.
 * เงื่อนไข (Condition) มีไว้สำหรับตรวจสอบสถานภาพของ object (ประเภท T) ว่า
 * object ที่สนใจนั้น อยู่ในสถานภาพที่สนใจหรือไม่
 *
 * @author INT105
 * @param <T> T is the object that may be in that particular state.
 */
public interface Condition<T> {

    /**
     * a method to check if the object t is in this condition or not.
     *
     * @param t is the object to be tested.
     * @return <strong>true</strong> if the object t meets this condition;
     * otherwise <strong>false</strong>.
     * @throws NullPointerException if t is null.
     */
    boolean test(T t);

    /**
     * a method to check if the object t is in this condition or not.
     *
     * @param t is the object to be tested.
     * @return <strong>false</strong> if the object t meets this condition;
     * otherwise <strong>true</strong>.
     * @throws NullPointerException if t is null.
     */
    default boolean testNot(T t) {
        return ! test(t);
    }

    /**
     * a method to create a condition that is the opposite to this condition.
     * 
     * @return condition that is opposite to itself
     */
    default Condition<T> not() {
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                return ! Condition.this.test(t);
            }
        };
    }

    /**
     * a method to create a condition that is the result of 
     * this condition AND the condition c
     * 
     * @param c the condition to AND with this condition
     * @return the AND condition of the two conditions
     * @throws NullPointerException if c is null.
     */
    default Condition<T> and(Condition<T> c) {
        Objects.requireNonNull(c, "Condition must not be null.");
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                Objects.requireNonNull(t, "Null cannot be tested.");
                return Condition.this.test(t) && c.test(t);
            }
        };
    }

    /**
     * a method to create a condition that is the result of 
     * this condition OR the condition c
     * 
     * @param c the condition to OR with this condition
     * @return the OR condition of the two conditions
     * @throws NullPointerException if c is null.
     */
    default Condition<T> or(Condition<T> c) {
        Objects.requireNonNull(c, "Condition must not be null.");
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                Objects.requireNonNull(t, "Null cannot be tested.");
                return Condition.this.test(t) || c.test(t);
            }
        };
    }
    
    /**
     * a static generic method to create a condition that is the result of 
     * AND of all conditions in the argument list
     * 
     * @param <T>
     * @param conditions
     * @return the condition that is the result of 
     * AND of all conditions in the argument list
     * @throws NullPointerException if "conditions" is null or contains null.
     */
    static <T> Condition<T> andAll(Condition<T> ... conditions) {
        Objects.requireNonNull(conditions, "Conditions must not be null.");
        for (Condition<T> cond : conditions) {
            Objects.requireNonNull(cond, "Condition must not be null.");
        }
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                Objects.requireNonNull(t, "Null cannot be tested.");
                for (Condition<T> cond : conditions) {
                    if (!cond.test(t)) return false;
                }
                return true;
            }
        };
    }

    /**
     * a static generic method to create a condition that is the result of 
     * OR of all conditions in the argument list
     * 
     * @param <T>
     * @param conditions
     * @return the condition that is the result of 
     * OR of all conditions in the argument list
     * @throws NullPointerException if "conditions" is null or contains null.
     */
    static <T> Condition<T> orAll(Condition<T> ... conditions) {
        Objects.requireNonNull(conditions, "Conditions must not be null.");
        for (Condition<T> cond : conditions) {
            Objects.requireNonNull(cond, "Condition must not be null.");
        }
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                Objects.requireNonNull(t, "Null cannot be tested.");
                for (Condition<T> cond : conditions) {
                    if (cond.test(t)) return true;
                }
                return false;
            }
        };
    }

    /**
     * a static generic method to create a condition to check 
     * if an object t of type T is equal to object o of type T.
     * 
     * @param <T>
     * @param o the object to match
     * @return the condition to check if an object t of type T 
     * is equal to object o of type T.
     * @throws NullPointerException if o is null.
     */
    static <T> Condition<T> isEqual(T o) {
        Objects.requireNonNull(o, "Parameter must not be null.");
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                Objects.requireNonNull(t, "Null cannot be tested.");
                return o.equals(t);
            }
        };
    }

    /**
     * a static generic method to create a condition that always returns true.
     * @param <T>
     * @return the condition that always returns true.
     */
    static <T> Condition<T> alwaysTrue() {
        return new Condition<T>() {
            @Override
            public boolean test(T t) {
                Objects.requireNonNull(t, "Null cannot be tested.");
                return true;
            }
        };
    }
    
    /**
     * a static generic method to create a condition that always returns false.
     * @param <T>
     * @return the condition that always returns false.
     */
    static <T> Condition<T> alwaysFalse() {
        return (Condition<T>) Condition.alwaysTrue().not();
    }
}
