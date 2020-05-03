package com.yk.training.bst;

/**
 * Basic BST operations: add, search, min, max.
 */
public class BSTOperations {

    public static void add(final int value, final Node subtree) {
        if (value == subtree.value) {
            return;
        }

        if (value < subtree.value) {
            if (subtree.left != null) {
                add(value, subtree.left);
            } else {
                subtree.left = new Node(value);
            }
        } else {
            if (subtree.right != null) {
                add(value, subtree.right);
            } else {
                subtree.right = new Node(value);
            }
        }
    }

    /**
     * Returns a {@link Node} if it is present in the tree; otherwise returns {@code null}.
     */
    public static Node search(final int value, final Node node) {
        if (node.value == value) {
            return node;
        }

        if (value < node.value && node.left != null) {
            return search(value, node.left);

        } else if (value > node.value && node.right != null) {
            return search(value, node.right);
        }

        return null;
    }

    public static Node min(final Node node) {
        if (node.left != null) {
            return min(node.left);
        }

        return node;
    }

    public static Node max(final Node node) {
        if (node.right != null) {
            return max(node.right);
        }

        return node;
    }
}
