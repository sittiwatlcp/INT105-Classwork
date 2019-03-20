package base;

/**
 * Condition is for holding a particular state that something (T) is in. 
 * เงื่อนไข (Condition) มีไว้สำหรับตรวจสอบสถานภาพของ object (ประเภท T) ว่า 
 * object ที่สนใจนั้น อยู่ในสถานภาพที่สนใจหรือไม่
 * @author INT105
 * @param <T> T is the object that may be in that particular state.
 */
public interface Condition<T> {
    /**
     * a method to check if the object t is in this condition or not.
     * @param t is the object to be tested.
     * @return <strong>true</strong> if the object t meets this condition; 
     * otherwise <strong>false</strong>.
     * @throws IllegalArgumentException if t is null.
     */
    boolean test(T t);
    
    /**
     * a method to check if the object t is in this condition or not.
     * @param t is the object to be tested.
     * @return <strong>false</strong> if the object t meets this condition; 
     * otherwise <strong>true</strong>.
     * @throws ConditionFailException if t is null.
     */
    default boolean reverseTest(T t) {
        return ! test(t);
    }
}
