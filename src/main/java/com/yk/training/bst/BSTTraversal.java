package com.yk.training.bst;

import com.yk.training.bst.visitors.ValuesPrinter;

import java.util.function.Consumer;

/**
 * Tree traversal algorithms:
 * <ul>
 * <li><b>preorder</b> -Visits current node, then the left subtree, then the right subtree.</li>
 * <li><b>inorder</b> - Visits the left subtree, then current node, then the right subtree.</li>
 * <li><b>postorder</b> - Visits the left subtree, then the right subtree, then current node.</li>
 * </ul>
 */
public class BSTTraversal {

    /**
     * Default consumer which prints nodes.
     */
    private static final Consumer<Node> NODE_PRINTER = new ValuesPrinter();

    /**
     * Used in tests to achieve high code coverage.
     */
    static Consumer<Node> ALTERNATIVE_NODE_PRINTER;

    /**
     *
     */
    public static void inorder(final Node node) {
        inorder(node, nodePrinter());
    }

    public static void inorder(final Node node, final Consumer<Node> visitor) {
        if (node.left != null) {
            inorder(node.left, visitor);
        }

        visitor.accept(node);

        if (node.right != null) {
            inorder(node.right, visitor);
        }
    }

    public static void preorder(final Node node) {
        preorder(node, nodePrinter());
    }

    public static void preorder(final Node node, final Consumer<Node> visitor) {
        visitor.accept(node);

        if (node.left != null) {
            preorder(node.left, visitor);
        }

        if (node.right != null) {
            preorder(node.right, visitor);
        }
    }

    public static void postorder(final Node node) {
        postorder(node, nodePrinter());
    }

    public static void postorder(final Node node, final Consumer<Node> visitor) {
        if (node.left != null) {
            postorder(node.left, visitor);
        }

        if (node.right != null) {
            postorder(node.right, visitor);
        }

        visitor.accept(node);
    }

    private static Consumer<Node> nodePrinter() {
        return ALTERNATIVE_NODE_PRINTER == null ? NODE_PRINTER : ALTERNATIVE_NODE_PRINTER;
    }
}
