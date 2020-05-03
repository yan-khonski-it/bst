package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;

import java.util.function.Consumer;

/**
 * Counts {@link Node}s in BST.
 */
public class NodesCounter implements Consumer<Node> {

    int count = 0;

    @Override
    public void accept(Node node) {
        count++;
    }

    public int getCount() {
        return count;
    }
}
