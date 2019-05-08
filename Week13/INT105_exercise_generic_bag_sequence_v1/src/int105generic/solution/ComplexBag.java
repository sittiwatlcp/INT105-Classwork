package int105generic.solution;

import int105generic.util.Condition;
import java.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class ComplexBag<T> extends StandardBag<T> implements ConditionalBag<T> {

    private Condition<T> condition;

    /**
     * create a bag with a default size and a condition that always returns
     * true.
     */
    public ComplexBag() {
        /* if this(...) or super(...) is called at the beginning of 
        the constructor, it will not call the default super() implicitly. */
        this(Condition.alwaysTrue());
    }

    /**
     * create a bag with a default size and a given condition
     *
     * @param condition the condition that is used to test if an object can be
     * added into the bag.
     * @throws NullPointerException if condition is null
     */
    public ComplexBag(Condition<T> condition) {
        // super(); // this line will be called implicitly.
        this.condition = Objects.requireNonNull(condition);
    }

    /**
     * create a bag with an initial size
     *
     * @param size the initial size of the bag
     * @throws NullPointerException if condition is null
     */
    public ComplexBag(int size) {
        this(size, Condition.alwaysTrue());
    }

    /**
     * create a bag with an initial size and a condition for adding objects into
     * the bag
     *
     * @param size the initial size of the bag
     * @param condition the condition that is used to test if an object can be
     * added into the bag.
     * @throws NullPointerException if condition is null
     */
    public ComplexBag(int size, Condition<T> condition) {
        super(size);
        this.condition = Objects.requireNonNull(condition);
    }

    /**
     * add object t into the bag. Only the object t that pass the condition can
     * be added. It does not check if the object has already been in the bag.
     *
     * @param t the object to be added
     * @return true if it is successfully added; otherwise return false.
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean add(T t) {
        if (condition.test(t)) {
            return super.add(t);
        }
        return false;
    }

    /**
     * remove an object that pass the condition c from the bag. If there are
     * multiple objects that pass the condition, remove just one of them.
     *
     * @param c the condition that is used to remove object t from the bag
     * @return the object that can pass the condition; otherwise return null
     * @throws NullPointerException if c is null
     */
    public T remove(Condition<T> c) {
        Iterator<T> i = iterator();
        while (i.hasNext()) {
            T t = i.next();
            if (c.test(t) && super.remove(t)) {
                return t;
            }
        }
        return null;
    }

    /**
     * check if there is an object in the bag that can pass the condition. If
     * there are multiple objects that pass the condition, return just one of
     * them.
     *
     * @param c the condition that is used to search objects in the bag
     * @return the object that can pass the condition; otherwise return null
     * @throws NullPointerException if c is null
     */
    public T contains(Condition<T> c) {
        Iterator<T> i = iterator();
        while (i.hasNext()) {
            T t = i.next();
            if (c.test(t)) {
                return t;
            }
        }
        return null;
    }

    /**
     * remove all objects that meet the condition c from the bag.
     *
     * @param c the condition that is used to remove objects from the bag
     * @return a Bag of objects that are removed; otherwise return an empty Bag
     * @throws NullPointerException if c is null
     */
    @Override
    public Bag<T> removeAll(Condition<T> c) {
        Bag<T> bag = new StandardBag<>();
        Iterator<T> it = iterator(c);
        while (it.hasNext()) {
            T t = it.next();
            bag.add(t);
            it.remove();
        }
        return bag;
    }

    /**
     * find all objects of type T that meet the condition c in the bag
     *
     * @param c the condition that is used to search for the objects
     * @return a Bag of all objects of type T that meets the condition c; or an
     * empty Bag if not found
     * @throws NullPointerException if c is null
     */
    @Override
    public Bag<T> allContains(Condition<T> c) {
        Bag<T> bag = new StandardBag<>();
        Iterator<T> it = iterator(c);
        while (it.hasNext()) {
            T t = it.next();
            bag.add(t);
        }
        return bag;
    }

    /**
     * an iterator that iterates over the bag of objects of type T that meets a
     * certain condition only
     *
     * @param c the condition that is used to iterate over the bag of objects of
     * type T
     * @return an iterator that will iterate over the bag of objects of type T
     * that meets the condition c only
     * @throws NullPointerException if c is null
     */
    @Override
    public Iterator<T> iterator(Condition<T> c) {
        Objects.requireNonNull(c);
        return new Iterator<T>() {

            private final Condition<T> condition = c;
            private Iterator<T> it = ComplexBag.this.iterator();
            private int modCount = ComplexBag.this.modCount;
            private T current; // for storing the current value for removable capabilty
            private T next; // for storing the look-ahead value

            // this is a non-static block, search web for explanation.
            {
                lookAhead();
            }

            private void validate() {
                if (modCount != ComplexBag.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            private void lookAhead() {
                while (it.hasNext()) {
                    next = it.next();
                    if (condition.test(next)) {
                        return;
                    }
                }
                next = null;
            }

            @Override
            public boolean hasNext() {
                validate();
                return next != null;
            }

            @Override
            public T next() {
                validate();
                if (next == null) {
                    throw new NoSuchElementException();
                }
                current = next;
                lookAhead();
                return current;
            }

            @Override
            public void remove() {
                validate();
                if (current == null) {
                    throw new IllegalStateException();
                }

                // reset internal iterator "it"
                it = ComplexBag.this.iterator();

                // search for the one to be removed
                while (it.hasNext()) {
                    T t = it.next();

                    // found the one to be removed
                    if (t == current) {

                        // remove it and reset the modCount value
                        it.remove();
                        current = null;
                        modCount = ComplexBag.this.modCount;

                        // check if there is any thing more
                        if (next == null) {
                            return;
                        }

                        // find the next one
                        lookAhead();

                        /* search for the usage of assert 
                        and how to turn it on in your IDE */
                        assert next != null : "Bug in ComplexBag<T>.iterator(Condition<T>).remove()";
                        return;
                    }
                }
                assert false : "Bug in ComplexBag<T>.iterator(Condition<T>).remove()";
            }
        };
    }
}
