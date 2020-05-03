package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;

import java.util.function.Consumer;

/**
 * Counts leave in BST.
 */
public class LeavesCounter implements Consumer<Node>  {

    int count = 0;

    @Override
    public void accept(Node node) {
        if (node.isLeave()) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
