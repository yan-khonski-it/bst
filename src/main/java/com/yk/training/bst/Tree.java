package com.yk.training.bst;


import java.util.List;

/**
 * Represents a binary search tree.
 * This class contains common operations performed on BST.
 * {@code empty} tree is also supported: {@code root} is {@code null}.
 */
public class Tree {

    /**
     * Contains additional details about the tree.
     */
    public TreeDetails treeDetails = new TreeDetails();

    /**
     * Not final, because we can remove a node and replace the root with another node.
     */
    public Node root;

    private Tree(Node root) {
        this.root = root;
    }

    public static Tree ofRoot(final int rootValue) {
        return new Tree(Node.of(rootValue));
    }

    public static Tree empty() {
        return new Tree(null);
    }

    public static Tree ofValues(final List<Integer> values) {
        final Tree tree = empty();
        values.forEach(tree::add);
        return tree;
    }

    /**
     * Adds a new key into BST.
     */
    public void add(int value) {
        if (isEmpty()) {
            root = new Node(value);
        } else {
            BSTOperations.add(value, root);
        }
    }

    public Node search(final int value) {
        if (isEmpty()) {
            return null;
        } else {
            return BSTOperations.search(value, root);
        }
    }

    public boolean remove(final int value) {
        NodeRemover.remove(value, this);
        return treeDetails.wasNodeRemoved;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isSingleNode() {
        return !isEmpty() && root.isLeave();
    }

    public Node min() {
        return BSTOperations.min(root);
    }

    public Node max() {
        return BSTOperations.max(root);
    }
}
