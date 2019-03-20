package base;

import peeking.PeekableIterable;
import peeking.PeekableIterator;

public class GenericList<T> implements PeekableIterable<T> {

    T[] list;
    int count;
    
    public GenericList() {
        this(8);
    }

    public T search(Condition<T> c) {
        if (c == null) return null;
        for (int i=0; i<count; i++) {
            if (c.test(list[i])) return list[i];
        }
        return null;
    }
    
    public GenericList(int size) {
        if (size<1) 
            throw new IllegalArgumentException("size must be larger than 0.");
        this.list = (T[]) new Object[size];
    }
    
    public boolean add(T s) {
        if (s == null || count == list.length) return false;
        list[count++] = s;
        return true;
    }
    
    @Override
    public PeekableIterator<T> iterator() {
        return new PeekableIterator<T>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index != count;
            }

            @Override
            public T next() {
                if (index == count) 
                    throw new IllegalStateException("No more element.");
                return list[index++];
            }
            
            @Override
            public T peek() {
                if (index == count) 
                    throw new IllegalStateException("No more element.");
                return list[index];
            }
        };
    }
}