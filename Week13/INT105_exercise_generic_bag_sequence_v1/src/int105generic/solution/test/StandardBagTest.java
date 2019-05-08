package int105generic.solution.test;

import int105generic.solution.Bag;
import int105generic.solution.StandardBag;
import java.util.Iterator;

public class StandardBagTest {

    public static void main(String[] args) {
        testStandardBag();
        testStandardBagIterator();
    }

    private static void testStandardBag() {
        System.out.println("\n---------------------------\nTest StandardBag<String>");
        System.out.println("test StandardBag<String>(), add(s), remove(s), contains(s), size()");
        Bag<String> b = new StandardBag<>();
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

        System.out.println("\ntest StandardBag<String>(2)");
        b = new StandardBag<>(2);
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
            b = new StandardBag<>(0);
        } catch (Exception e) {
            System.out.println("Exception: StandardBag<>(0) : " + e);
        }
    }

    private static void testStandardBagIterator() {
        System.out.println("\n---------------------------\nTest StandardBag<String> Iterator<String>");
        Bag<String> b = new StandardBag<>();
        System.out.println("add A: " + b.add("A"));
        System.out.println("add B: " + b.add("B"));
        Iterator<String> i = b.iterator();
        System.out.println("Get an iterator.");
        if (i.hasNext()) {
            System.out.println("iterator.next(): " + i.next());
        }
        System.out.println("add C: " + b.add("C"));
        try {
            if (i.hasNext()) {
                System.out.println("iterator.next(): " + i.next());
            }
        } catch (Exception e) {
            System.out.println("Iterating after structural modification: " + e);
        }

        System.out.println("\nIterator Retry ...");
        b = new StandardBag<String>();
        System.out.println("size: " + b.size());
        System.out.println("add One: " + b.add("One"));
        System.out.println("add Two: " + b.add("Two"));
        System.out.println("add Three: " + b.add("Three"));
        System.out.println("add Four: " + b.add("Four"));
        System.out.println("add Five: " + b.add("Five"));
        System.out.println("add Six: " + b.add("Six"));
        System.out.println("add Seven: " + b.add("Seven"));
        System.out.println("size: " + b.size());
        i = b.iterator();
        try {
            System.out.println("iterator.remove() ");
            i.remove();
        } catch (Exception e) {
            System.out.println("iterator: remove() before next(): " + e);
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
            System.out.println("iterator: remove() twice before next(): " + e);
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
            System.out.println("iterator: next() beyond the last one: " + e);
        }
    }

}
