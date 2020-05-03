package com.yk.training.bst;

/**
 * Represents additional details about the {@link Tree}.
 */
public class TreeDetails {

    /**
     * If {@link Tree#remove(int)} was called, it will contain {@code true} if the node was removed.
     */
    boolean wasNodeRemoved = false;

    public TreeDetails() {
    }

    public void reset() {
        wasNodeRemoved = false;
    }

    public void nodeRemoved() {
        wasNodeRemoved = true;
    }
}
