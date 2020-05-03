package com.yk.training.bst;

/**
 * Represents additional details about the {@link Node}.
 */
public class NodeDetails {

    int level = 0;

    public NodeDetails(final int level) {
        this.level = level;
    }

    public static NodeDetails of(final int level) {
        return new NodeDetails(level);
    }

    public int getLevel() {
        return level;
    }
}
