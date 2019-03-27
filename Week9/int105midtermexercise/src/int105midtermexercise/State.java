/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105midtermexercise;

/**
 *
 * @author INT105
 */
public enum State {
    EMPTY,
    READY,
    FULL;

    public static State firstState() {
        return EMPTY;
    }

    public State next() {
        switch (this) {
            case EMPTY:
                return READY;
            case READY:
                return EMPTY;
            case FULL:
                return READY;
            default:
                throw new IllegalStateException();
        }
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    public boolean isFull() {
        return this == FULL;
    }

    public boolean isReady() {
        return this != EMPTY;
    }
}


