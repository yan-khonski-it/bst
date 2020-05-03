package com.yk.training.bst;

import com.yk.training.bst.visitors.LeavesCounter;
import com.yk.training.bst.visitors.NodesCounter;

/**
 * Counts leaves, nodes, high of the tree, etc.
 */
public class BSTCounter {

    public static int totalNodes(final Node node) {
        if (node == null) {
            return 0;
        }

        final NodesCounter nodesCounter = new NodesCounter();
        BSTTraversal.inorder(node, nodesCounter);
        return nodesCounter.getCount();
    }

    public static int leaves(final Node node) {
        if (node == null) {
            return 0;
        }

        final LeavesCounter leavesCounter = new LeavesCounter();
        BSTTraversal.inorder(node, leavesCounter);
        return leavesCounter.getCount();
    }

    public static int height(final Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }
}