package int105generic.solution.test;

import int105generic.solution.Bag;
import int105generic.solution.ComplexBag;
import int105generic.solution.ConditionalBag;
import int105generic.util.Condition;
import java.util.Iterator;
import java.util.Objects;

public class ComplexBagTest {

    public static void main(String[] args) {
        testComplexBagAsBag();
        testComplexBagAsConditionalBag();
        testComplexBagIterator();
        testComplexBagConditionalIterator();
    }

    private static void testComplexBagAsBag() {
        System.out.println("\n---------------------------\nTest ComplexBag<String> as Bag<String>");
        System.out.println("test ComplexBag<String>(), add(s), remove(s), contains(s), size()");
        Bag<String> b = new ComplexBag<>();
        System.out.println("size: " + b.size());
        System.out.println("add One: " + b.add("One"));
        System.out.println("add Two: " + b.add("Two"));
        System.out.println("add Three: " + b.add("Three"));
        System.out.println("add Two: " + b.add("Two"));
        System.out.println("size: " + b.size());
        System.out.println("Contain Two: " + b.contains("Two"));
        System.out.println("Contain Five: " + b.contains("Five"));
        System.out.println("Remove Two: " + b.remove("Two"));
        System.out.println("Contain Two: " + b.contains("Two"));
        System.out.println("size: " + b.size());
        System.out.println("Remove Two: " + b.remove("Two"));
        System.out.println("Contain Two: " + b.contains("Two"));
        System.out.println("size: " + b.size());

        System.out.println("\ntest ComplexBag<String>(2)");
        b = new ComplexBag<>(2);
        System.out.println("add One: " + b.add("One"));
        System.out.println("add Two: " + b.add("Two"));
        System.out.println("add Three: " + b.add("Three"));
        System.out.println("add Four: " + b.add("Four"));
        System.out.println("size: " + b.size());

        try {
            System.out.println("add null");
            b.add(null);
        } catch (Exception e) {
            System.out.println("Exception: add null : " + e);
        }
        try {
            System.out.println("remove null");
            b.remove(null);
        } catch (Exception e) {
            System.out.println("Exception: remove null : " + e);
        }
        try {
            System.out.println("contains null");
            b.contains(null);
        } catch (Exception e) {
            System.out.println("Exception: contains null : " + e);
        }
        try {
            System.out.println("Constructor: new StandardBag<>(0) ");
            System.out.println(new ComplexBag<>(0));
        } catch (Exception e) {
            System.out.println("Exception: StandardBag<>(0) : " + e);
        }
    }

    private static Condition<String> stringContains(String s) {
        Objects.requireNonNull(s);
        return new Condition<String>() {
            @Override
            public boolean test(String t) {
                return Objects.requireNonNull(t).contains(s);
            }
        };
    }

    private static void testComplexBagAsConditionalBag() {
        System.out.println("\n---------------------------\nTest ComplexBag<String> as ConditionalBag<String>");
        System.out.println("test ComplexBag<String>(Condition<String>), add(s), remove(s), contains(s), size()");
        System.out.println("Bag containing String with e");
        ConditionalBag<String> b = new ComplexBag<>(stringContains("e"));
        System.out.println("size: " + b.size());
        System.out.println("add one: " + b.add("one"));
        System.out.println("add two: " + b.add("two"));
        System.out.println("add three: " + b.add("three"));
        System.out.println("add four: " + b.add("four"));
        System.out.println("add five: " + b.add("five"));
        System.out.println("add six: " + b.add("six"));
        System.out.println("add seven: " + b.add("seven"));
        System.out.println("add eight: " + b.add("eight"));
        System.out.println("add nine: " + b.add("nine"));
        System.out.println("add one: " + b.add("one"));
        System.out.println("size: " + b.size());
        System.out.println("Contain ten: " + b.contains("ten"));
        System.out.println("Contain two: " + b.contains("two"));
        System.out.println("Contain one: " + b.contains("one"));
        System.out.println("Remove one: " + b.remove("one"));
        System.out.println("Contain one: " + b.contains("one"));
        System.out.println("size: " + b.size());
        System.out.println("Remove one: " + b.remove("one"));
        System.out.println("Contain one: " + b.contains("one"));
        System.out.println("size: " + b.size());

        System.out.println("\ntest contains and remove with Condition<String> contains i");
        Condition<String> containsI = stringContains("i");
        String s;
        do {
            System.out.println("Contain i: " + b.contains(containsI));
            s = b.remove(containsI);
            System.out.println("Remove i: " + s);
        } while (s != null);
        System.out.println("size: " + b.size());
        System.out.println("\nremoving the rest ...");
        Condition<String> any = Condition.alwaysTrue();
        do {
            s = b.remove(any);
            System.out.println("remove anything: " + s);
        } while (s != null);
        System.out.println("size: " + b.size());

        System.out.println("\ntest ComplexBag<String>(2, Condition<String>)");
        System.out.println("New Bag containing String with o");
        b = new ComplexBag<>(2, stringContains("o"));
        System.out.println("add one: " + b.add("one"));
        System.out.println("add two: " + b.add("two"));
        System.out.println("add three: " + b.add("three"));
        System.out.println("add four: " + b.add("four"));
        System.out.println("size: " + b.size());

        try {
            System.out.println("add null");
            b.add(null);
        } catch (Exception e) {
            System.out.println("Exception: add null : " + e);
        }
        try {
            System.out.println("remove Condition null");
            b.remove((Condition<String>) null);
        } catch (Exception e) {
            System.out.println("Exception: remove Condition<String> null : " + e);
        }
        try {
            System.out.println("contains Condition null");
            b.contains((Condition<String>) null);
        } catch (Exception e) {
            System.out.println("Exception: contains Condition<String> null : " + e);
        }
        try {
            System.out.println("Constructor: new ComplexBag<>(null) ");
            System.out.println(new ComplexBag<>(null));
        } catch (Exception e) {
            System.out.println("Exception: ComplexBag<>(null) : " + e);
        }
    }

    private static void testComplexBagIterator() {
        System.out.println("\n---------------------------\nTest ComplexBag<String> Iterator<String>");
        System.out.println("New Bag containing String with e");
        Bag<String> b = new ComplexBag<>(stringContains("e"));
        System.out.println("add one: " + b.add("one"));
        System.out.println("add two: " + b.add("two"));
        System.out.println("size: " + b.size());
        System.out.println("Get an iterator.");
        Iterator<String> i = b.iterator();
        if (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        System.out.println("add three: " + b.add("three"));
        System.out.println("size: " + b.size());
        try {
            if (i.hasNext()) {
                System.out.println("iterator.next(): " + i.next());
            }
        } catch (Exception e) {
            System.out.println("iterator.next() fails after structural modification: " + e);
        }
        System.out.println("add four: " + b.add("four"));
        System.out.println("add five: " + b.add("five"));
        System.out.println("size: " + b.size());
        System.out.println("Get a new iterator.");
        i = b.iterator();
        System.out.println("add six: " + b.add("six"));
        try {
            if (i.hasNext()) {
                System.out.println("iterator.next(): " + i.next());
                System.out.println("iterator.remove().");
                i.remove();
            }
        } catch (Exception e) {
            System.out.println("Not show up in the output because six has no 'e': " + e);
        }
        System.out.println("size: " + b.size());
        try {
            if (i.hasNext()) {
                System.out.println("iterator.next(): " + i.next());
            }
        } catch (Exception e) {
            System.out.println("Not show in the output because removing through this iterator: " + e);
        }
        System.out.println("remove 'r': " + ((ConditionalBag) b).remove(stringContains("r")));
        System.out.println("size: " + b.size());
        try {
            if (i.hasNext()) {
                System.out.println("iterator.next(): " + i.next());
            }
        } catch (Exception e) {
            System.out.println("iterator.next() fails after removing an object from the bag: " + e);
        }

        System.out.println("\nIterator Retry ...");
        System.out.println("New Bag containing String with e");
        b = new ComplexBag<>(stringContains("e"));
        System.out.println("size: " + b.size());
        System.out.println("add one: " + b.add("one"));
        System.out.println("add two: " + b.add("two"));
        System.out.println("add three: " + b.add("three"));
        System.out.println("add four: " + b.add("four"));
        System.out.println("add five: " + b.add("five"));
        System.out.println("add six: " + b.add("six"));
        System.out.println("add seven: " + b.add("seven"));
        System.out.println("add eight: " + b.add("eight"));
        System.out.println("add nine: " + b.add("nine"));
        System.out.println("size: " + b.size());
        i = b.iterator();
        try {
            System.out.println("iterator.remove() ");
            i.remove();
        } catch (Exception e) {
            System.out.println("Fail: iterator.remove() before next(): " + e);
        }
        if (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        if (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        System.out.println("iterator.remove() ");
        i.remove();
        System.out.println("size: " + b.size());
        try {
            System.out.println("iterator.remove() ");
            i.remove();
        } catch (Exception e) {
            System.out.println("Fail: iterator.remove() twice before next(): " + e);
        }
        System.out.println("size: " + b.size());
        if (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        if (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        System.out.println("iterator.remove() ");
        i.remove();
        System.out.println("size: " + b.size());
        while (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        System.out.println("size: " + b.size());
        try {
            System.out.println("iterator.next(): " + i.next());
        } catch (Exception e) {
            System.out.println("Fail: iterator.next() beyond the last one: " + e);
        }
    }

    private static void testComplexBagConditionalIterator() {
        System.out.println("\n---------------------------\nTest ComplexBag<String> Conditional Iterator<String>");
        System.out.println("ComplexBag containing String with e");
        ComplexBag<String> b = new ComplexBag<>(stringContains("e"));
        System.out.println("size: " + b.size());
        System.out.println("add one: " + b.add("one"));
        System.out.println("add two: " + b.add("two"));
        System.out.println("add three: " + b.add("three"));
        System.out.println("add four: " + b.add("four"));
        System.out.println("add five: " + b.add("five"));
        System.out.println("add six: " + b.add("six"));
        System.out.println("add seven: " + b.add("seven"));
        System.out.println("add eight: " + b.add("eight"));
        System.out.println("add nine: " + b.add("nine"));
        System.out.println("add ten: " + b.add("ten"));
        System.out.println("add eleven: " + b.add("eleven"));
        System.out.println("add twelve: " + b.add("twelve"));
        System.out.println("add thirteen: " + b.add("thirteen"));
        System.out.println("add fourteen: " + b.add("fourteen"));
        System.out.println("add fifteen: " + b.add("fifteen"));
        System.out.println("add sixteen: " + b.add("sixteen"));

        System.out.println("\nIterator only string with i");
        Iterator<String> i = b.iterator(stringContains("i"));
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
            System.out.println("Iterator: " + i.next());
        } catch (Exception e) {
            System.out.println("Iterate after the last one: " + e);
        }

        System.out.println("\nRedo iterator only string with i");
        i = b.iterator(stringContains("i"));
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
            System.out.println("Remove the last one.");
            i.remove();
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        System.out.println("\nList all and try removing the last one twice ...");
        i = b.iterator(stringContains("i"));
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
            i.remove();
            i.remove();
        } catch (Exception e) {
            System.out.println("Exception because of two consecutive remove(): " + e);
        }

        System.out.println("\nRedo iterator only string with i");
        i = b.iterator(stringContains("i"));
        try {
            System.out.println("Iterator: " + i.next());
            System.out.println("Remove."); i.remove();
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        try {
            System.out.println("Remove again after another remove.");
            i.remove();
        } catch (Exception e) {
            System.out.println("Cannot remove consecutively.");
        }

        System.out.println("\nRedo iterator:");
        i = b.iterator();
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }

        System.out.println("\nRedo iterator only string with i");
        i = b.iterator(stringContains("i"));
        try {
            System.out.println("Iterator: " + i.next());
            System.out.println("Iterator: " + i.next());
            System.out.println("Remove."); i.remove();
            System.out.println("Iterator: " + i.next());
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        System.out.println("\nRedo iterator:");
        i = b.iterator();
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        
        System.out.println("\ntest allContains string with t");
        Bag<String> bs = b.allContains(stringContains("t"));
        i = bs.iterator();
        while (i.hasNext()) {
            System.out.println("String contains t: " + i.next());
        }

        System.out.println("\ntest allContains string without t");
        bs = b.allContains(stringContains("t").not());
        i = bs.iterator();
        while (i.hasNext()) {
            System.out.println("String contains t: " + i.next());
        }
        
        System.out.println("\ntest removeAll string with t");
        bs = b.removeAll(stringContains("t"));
        i = bs.iterator();
        while (i.hasNext()) {
            System.out.println("Removed string contains t: " + i.next());
        }
        System.out.println("\nRedo iterator:");
        i = b.iterator();
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
    }
}
