package int105generic.solution.test;

import java.util.Objects;
import java.util.Iterator;
import java.util.Comparator;
import int105generic.solution.Bag;
import int105generic.util.Condition;
import int105generic.solution.Sequence;
import int105generic.solution.NormalSequence;

public class NormalSequenceTest {

    public static void main(String[] args) {
        testNormalSequenceAsBag();
        testNormalSequenceAsSequence();
        testSequenceIterator();
        testSequenceConditionalIterator();
        testSequenceSorting();
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

    private static Comparator<String> stringLengthComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String s, String t) {
                return s.length() - t.length();
            }
        };
    }

    private static void testNormalSequenceAsBag() {
        System.out.println("\n---------------------------\nTest NormalSequence<String> as Bag<String>");
        System.out.println("test NormalSequence<String>(), add(s), remove(s), contains(s), size()");
        Bag<String> bag = new NormalSequence<>();
        System.out.println("size: " + bag.size());
        System.out.println("add One: " + bag.add("One"));
        System.out.println("add Two: " + bag.add("Two"));
        System.out.println("add Three: " + bag.add("Three"));
        System.out.println("add Two: " + bag.add("Two"));
        System.out.println("size: " + bag.size());
        System.out.println("Contain Two: " + bag.contains("Two"));
        System.out.println("Contain Five: " + bag.contains("Five"));
        System.out.println("Remove Two: " + bag.remove("Two"));
        System.out.println("Contain Two: " + bag.contains("Two"));
        System.out.println("size: " + bag.size());
        System.out.println("Remove Two: " + bag.remove("Two"));
        System.out.println("Contain Two: " + bag.contains("Two"));
        System.out.println("size: " + bag.size());

        System.out.println("\ntest NormalSequence<String>(2)");
        bag = new NormalSequence<>(2);
        System.out.println("add One: " + bag.add("One"));
        System.out.println("add Two: " + bag.add("Two"));
        System.out.println("add Three: " + bag.add("Three"));
        System.out.println("add Four: " + bag.add("Four"));
        System.out.println("size: " + bag.size());

        try {
            System.out.println("add null");
            bag.add(null);
        } catch (Exception e) {
            System.out.println("Exception: add null : " + e);
        }
        try {
            System.out.println("remove null");
            bag.remove((String) null);
        } catch (Exception e) {
            System.out.println("Exception: remove null : " + e);
        }
        try {
            System.out.println("contains null");
            bag.contains((String) null);
        } catch (Exception e) {
            System.out.println("Exception: contains null : " + e);
        }
        try {
            System.out.println("Constructor: new NormalSequence<>(0) ");
            System.out.println(new NormalSequence<>(0));
        } catch (Exception e) {
            System.out.println("Exception: NormalSequence<>(0) : " + e);
        }
    }

    private static void testNormalSequenceAsSequence() {
        System.out.println("\n---------------------------\nTest NormalSequence<String> as Sequence<String>");
        System.out.println("test NormalSequence<String>(Condition<String>), add(s), remove(s), contains(s), size()");
        System.out.println("Sequence containing String with e");
        Sequence<String> seq = new NormalSequence<>(stringContains("e"));
        System.out.println("size: " + seq.size());
        System.out.println("add one: " + seq.add("one"));
        System.out.println("add two: " + seq.add("two"));
        System.out.println("add three: " + seq.add("three"));
        System.out.println("add four: " + seq.add("four"));
        System.out.println("add five: " + seq.add("five"));
        System.out.println("add six: " + seq.add("six"));
        System.out.println("add seven: " + seq.add("seven"));
        System.out.println("add eight: " + seq.add("eight"));
        System.out.println("add nine: " + seq.add("nine"));
        System.out.println("add one: " + seq.add("one"));
        System.out.println("size: " + seq.size());
        System.out.println("Contain ten: " + seq.contains("ten"));
        System.out.println("Contain two: " + seq.contains("two"));
        System.out.println("Contain one: " + seq.contains("one"));
        System.out.println("Remove one: " + seq.remove("one"));
        System.out.println("Contain one: " + seq.contains("one"));
        System.out.println("size: " + seq.size());
        System.out.println("Remove one: " + seq.remove("one"));
        System.out.println("Contain one: " + seq.contains("one"));
        System.out.println("size: " + seq.size());

        System.out.println("\ntest contains and remove with Condition<String> contains i");
        Condition<String> containsI = stringContains("i");
        String s;
        do {
            System.out.println("Contain i: " + seq.contains(containsI));
            s = seq.remove(containsI);
            System.out.println("Remove i: " + s);
        } while (s != null);
        System.out.println("size: " + seq.size());
        System.out.println("\nremoving the rest ...");
        Condition<String> any = Condition.alwaysTrue();
        do {
            s = seq.remove(any);
            System.out.println("remove anything: " + s);
        } while (s != null);
        System.out.println("size: " + seq.size());

        System.out.println("\ntest NormalSequence<String>(2, Condition<String>)");
        System.out.println("New Sequence containing String with o");
        seq = new NormalSequence<>(2, stringContains("o"));
        System.out.println("add one: " + seq.add("one"));
        System.out.println("add two: " + seq.add("two"));
        System.out.println("add three: " + seq.add("three"));
        System.out.println("add four: " + seq.add("four"));
        System.out.println("size: " + seq.size());

        try {
            System.out.println("add null");
            seq.add(null);
        } catch (Exception e) {
            System.out.println("Exception: add null : " + e);
        }
        try {
            System.out.println("remove Condition null");
            seq.remove((Condition<String>) null);
        } catch (Exception e) {
            System.out.println("Exception: remove Condition<String> null : " + e);
        }
        try {
            System.out.println("contains Condition null");
            seq.contains((Condition<String>) null);
        } catch (Exception e) {
            System.out.println("Exception: contains Condition<String> null : " + e);
        }
        try {
            System.out.println("Constructor: new NormalSequence<>(null) ");
            System.out.println(new NormalSequence<>(null));
        } catch (Exception e) {
            System.out.println("Exception: NormalSequence<>(null) : " + e);
        }
    }

    private static void testSequenceIterator() {
        System.out.println("\n---------------------------\nTest NormalSequence<String> Iterator<String>");
        System.out.println("New Sequence containing String with e");
        Sequence<String> b = new NormalSequence<>(stringContains("e"));
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
        System.out.println("remove 'r': " + b.remove(stringContains("r")));
        System.out.println("size: " + b.size());
        try {
            if (i.hasNext()) {
                System.out.println("iterator.next(): " + i.next());
            }
        } catch (Exception e) {
            System.out.println("iterator.next() fails after removing an object from the sequence: " + e);
        }

        System.out.println("\nIterator Retry ...");
        System.out.println("New Sequence containing String with e");
        b = new NormalSequence<>(stringContains("e"));
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

    private static void testSequenceConditionalIterator() {
        System.out.println("\n---------------------------\nTest NormalSequence<String> Conditional Iterator<String>");
        System.out.println("New Sequence containing String with e");
        Sequence<String> s = new NormalSequence<>(stringContains("e"));
        System.out.println("size: " + s.size());
        System.out.println("add one: " + s.add("one"));
        System.out.println("add two: " + s.add("two"));
        System.out.println("add three: " + s.add("three"));
        System.out.println("add four: " + s.add("four"));
        System.out.println("add five: " + s.add("five"));
        System.out.println("add six: " + s.add("six"));
        System.out.println("add seven: " + s.add("seven"));
        System.out.println("add eight: " + s.add("eight"));
        System.out.println("add nine: " + s.add("nine"));
        System.out.println("add ten: " + s.add("ten"));
        System.out.println("add eleven: " + s.add("eleven"));
        System.out.println("add twelve: " + s.add("twelve"));
        System.out.println("add thirteen: " + s.add("thirteen"));
        System.out.println("add fourteen: " + s.add("fourteen"));
        System.out.println("add fifteen: " + s.add("fifteen"));
        System.out.println("add sixteen: " + s.add("sixteen"));
        System.out.println("size: " + s.size());

        System.out.println("\nIterator only string with i");
        Iterator<String> i = s.iterator(stringContains("i"));
        System.out.println("try iterating after the last one...");
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
            System.out.println("Iterator: " + i.next());
        } catch (Exception e) {
            System.out.println("Expected Exception: iterate after the last one: " + e);
        }

        System.out.println("\nRedo iterator only string with i");
        System.out.println("Removing the last one.");
        i = s.iterator(stringContains("i"));
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
            System.out.println("Remove the last one.");
            i.remove();
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        System.out.println("size: " + s.size());

        System.out.println("\nList all and try removing the last one twice ...");
        i = s.iterator(stringContains("i"));
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
            System.out.println("remove the last one"); i.remove();
            System.out.println("remove again"); i.remove();
        } catch (Exception e) {
            System.out.println("Expected Exception: two consecutive remove() exception: " + e);
        }
        System.out.println("size: " + s.size());

        System.out.println("\nRedo iterator only string with i");
        System.out.println("Remove the first one twice.");
        i = s.iterator(stringContains("i"));
        try {
            System.out.println("Iterator: " + i.next());
            System.out.println("Remove."); i.remove();
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        System.out.println("size: " + s.size());
        try {
            System.out.println("Remove again."); i.remove();
        } catch (Exception e) {
            System.out.println("Expected Exception: cannot remove consecutively: " + e);
        }
        System.out.println("size: " + s.size());

        System.out.println("\nRedo iterator only string with i");
        i = s.iterator(stringContains("i"));
        try {
            System.out.println("Iterator: " + i.next());
            System.out.println("Iterator: " + i.next());
            System.out.println("Remove."); i.remove();
            System.out.println("Iterator: " + i.next());
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
        System.out.println("size: " + s.size());
        
        System.out.println("\ntest allContains string with t");
        Bag<String> bs = s.allContains(stringContains("t"));
        i = bs.iterator();
        while (i.hasNext()) {
            System.out.println("String contains t: " + i.next());
        }

        System.out.println("\ntest allContains string without t");
        bs = s.allContains(stringContains("t").not());
        i = bs.iterator();
        while (i.hasNext()) {
            System.out.println("String contains t: " + i.next());
        }
        
        System.out.println("\ntest removeAll string with t");
        bs = s.removeAll(stringContains("t"));
        i = bs.iterator();
        while (i.hasNext()) {
            System.out.println("Removed string contains t: " + i.next());
        }
        System.out.println("size: " + s.size());
        
        System.out.println("\nList the rest:");
        i = s.iterator();
        try {
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
        } catch (Exception e) {
            System.out.println("Should not cause an exception: " + e);
        }
    }

    private static void testSequenceSorting() {
        System.out.println("\n---------------------------\nTest NormalSequence<String> sorting");
        System.out.println("Sequence containing String with e");
        Sequence<String> seq = new NormalSequence<>(stringContains("e"));
        System.out.println("size: " + seq.size());
        System.out.println("add one: " + seq.add("one"));
        System.out.println("add two: " + seq.add("two"));
        System.out.println("add three: " + seq.add("three"));
        System.out.println("add four: " + seq.add("four"));
        System.out.println("add five: " + seq.add("five"));
        System.out.println("add six: " + seq.add("six"));
        System.out.println("add seven: " + seq.add("seven"));
        System.out.println("add eight: " + seq.add("eight"));
        System.out.println("add nine: " + seq.add("nine"));
        System.out.println("size: " + seq.size());
        Iterator<String> i = seq.iterator();
        System.out.println("List all:");
        while (i.hasNext()) {
            System.out.println("Next: " + i.next());
        }
        seq.sort(stringLengthComparator());
        i = seq.iterator();
        System.out.println("List all after sorting based on the string length:");
        while (i.hasNext()) {
            System.out.println("Next: " + i.next());
        }
        seq.sort();
        i = seq.iterator();
        System.out.println("List all after sorting in its natural order (alphabetically):");
        while (i.hasNext()) {
            System.out.println("Next: " + i.next());
        }
    }
}
