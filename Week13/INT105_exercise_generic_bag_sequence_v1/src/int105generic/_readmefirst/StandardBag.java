package int105generic._readmefirst;

/*
Problem:
(Prerequisite: create the Bag<T> interface, the SimpleBag<T> class)

Create StandardBag<T> class that extends SimpleBag<T> class.
The behavior of SimpleBag's iterator is incorrect (fail unpredictably) 
if the iterator is used when SimpleBag is modified structurally.
StandardBag<T> extends SimpleBag<T> to correct this behavior.
That is the iterator should throw ConcurrentModificationException if 
the bag is structurally modified while iterating unless it is modified 
through that iterator using iterator.remove(). This behavior is called 
"fail-fast". It prevents the iterator to fail unpredictably.
 */

public class StandardBag<T> extends SimpleBag<T> {
    /* override neccessary methods and add more neccessary variables 
    but do not modify any code or change anything in SimpleBag<T> class. */
}
