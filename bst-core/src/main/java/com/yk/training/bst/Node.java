package com.yk.training.bst;

/**
 * Represents a node in a binary tree.
 */
@SuppressWarnings("PMD.MethodArgumentCouldBeFinal") // No getters and setters  on purpose of algorithm clarity.
public class Node {

    public Node left;
    public Node right;
    public int value;
    public NodeDetails nodeDetails;

    public Node(int value) {
        this.value = value;
    }

    public static Node of(final int value) {
        return new Node(value);
    }

    /**
     * @return {@code true} if this node is a leaf: it has no children.
     */
    public boolean isLeave() {
        return left == null && right == null;
    }

    /**
     * @return {@code true} if this node has both children.
     */
    public boolean hasBothChildren() {
        return left != null && right != null;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
