/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105midtermexercise;

import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author INT105
 */
public class SimpleList<T> implements NonNullList<T> {

    protected State state;
    protected T[] content;
    protected int first;
    protected int last;

    public SimpleList(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("List size must be larger than 0");
        }
        this.state = State.firstState();
        this.content = (T[]) new Object[size];
    }

    public SimpleList() {
        this(16);
    }

    @Override
    public boolean append(T t) {
        Objects.requireNonNull(t, "List does not allow null.");
        if (state.isFull()) {
            return false;
        }
        this.content[this.last++] = t;
        this.state = this.last == this.content.length ? State.FULL : State.READY;
        return true;
    }

    @Override
    public T remove() {
        if (state.isEmpty()) {
            return null;
        }
        T t = this.content[this.first];
        this.content[this.first++] = null;
        this.state = this.first == this.last ? State.EMPTY : State.READY;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos;
            @Override
            public boolean hasNext() {
                return this.pos != last;
            }

            @Override
            public T next() {
                if(pos == last) throw new IllegalStateException("No more Element");
                return content[pos++];
            }
        };
    }

    @Override
    public int length(){
        return last - first;
    }
}
