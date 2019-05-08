package int105generic.util.example;
        
import int105generic.util.Condition;
import java.util.Objects;

public class ConditionTest {
    public static void main(String[] args) {

        // Is a string within the length of 11 characters?
        Condition<String> elevenDown = new VarChar(11);

        // Is a string longer than 6?
        Condition<String> sevenUp = new VarChar(6).not();

        // Is a string length between 7 and 11 inclusively?
        Condition<String> sevenEleven = Condition.andAll(sevenUp, elevenDown);
        
        // Does a string contain "am"?
        Condition<String> amIn = new StringContains("am");

        // Is a string equal "Groot"?
        Condition<String> groot = Condition.isEqual("Groot");
        
        String[] strings = {"I am Groot", "Groot", "Madam, I am Adam", "m" };
        
        Condition<String>[] conds = (Condition<String> []) new Condition[10];
        conds[0] = elevenDown;
        conds[1] = sevenUp;
        conds[2] = sevenEleven;
        conds[3] = amIn;
        conds[4] = groot;
        conds[5] = amIn.or(groot);
        conds[6] = groot.not();
        conds[7] = (Condition<String>) Condition.orAll(groot, elevenDown.not());
        conds[8] = Condition.alwaysTrue();
        conds[9] = Condition.alwaysFalse();
        String[] messages = {"11 or shorter", "7 or longer", "between 7 and 11",
            "contains 'am'", "is 'Groot'", "contains 'am' or is 'Groot'", 
            "not 'Groot'", "'Groot' or longer than 11", 
            "always true", "always false"};
        
        System.out.println("\ntest() -----------------");
        for (String s : strings) {
            for (int i = 0; i < conds.length; i++) {
                if (conds[i].test(s)) 
                    System.out.println("'" + s + "' = " + messages[i]);
            }
        }
        System.out.println("\ntestNot() -----------------");
        for (String s : strings) {
            for (int i = 0; i < conds.length; i++) {
                if (conds[i].testNot(s)) 
                    System.out.println("'" + s + "' != " + messages[i]);
            }
        }
    }
}

/* a condition that tests if a string is within a given length */
class VarChar implements Condition<String> {
    private final int maxLength;

    public VarChar(int maxLength) {
        if (maxLength < 0) throw new IllegalArgumentException();
        this.maxLength = maxLength;
    }

    @Override
    public boolean test(String t) {
        return (Objects.requireNonNull(t)).length() <= maxLength;
    }
}

/* a condition that tests if a string contains a given string */
class StringContains implements Condition<String> {    
    private final String s;

    public StringContains(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean test(String t) {
        return (Objects.requireNonNull(t)).contains(s);
    }
}
