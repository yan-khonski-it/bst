package com.yk.training.bst;

/**
 * Util class which removes {@link Node} from {@link Tree}.
 *
 * Note, do not use this class directly. Use {@link Tree#remove(int)}.
 */
public class NodeRemover {

    /**
     * Removes a {@link Node} from BST.
     * <p>
     * If the node with given {@code value} was found and removed;
     * it sets {@link @TreeDetails#wasNodeRemoved} to {@code true}.
     */
    public static void remove(final int value, final Tree tree) {
        tree.treeDetails.reset();
        if (tree.isEmpty()) {
            return;
        }

        if (tree.root.isLeave()) {
            if (tree.root.value == value) {
                tree.root = null;
                tree.treeDetails.nodeRemoved();
            }
            return;
        }

        tree.root = remove(value, tree.root, tree.treeDetails);
    }

    /**
     * {@link TreeDetails} will contain {@code true}
     * if the node with given {@code value} was found and removed.
     *
     * @return root of a new subtree after the node removal.
     */
    private static Node remove(final int value, final Node node, final TreeDetails treeDetails) {
        if (value == node.value) {
            // Remove current node.
            if (node.isLeave()) {
                treeDetails.nodeRemoved();
                return null;
            } else if (node.hasBothChildren()) {
                // Find min element in right subtree and replace it with current node
                final NodeValueHolder nodeValueHolder = new NodeValueHolder();
                node.right = removeMinElement(node.right, nodeValueHolder);
                node.value = nodeValueHolder.savedValue;
                treeDetails.nodeRemoved();
                return node;
            }

            // Replace current node with right subtree.
            if (node.left == null && node.right != null) {
                treeDetails.nodeRemoved();
                return node.right;
            }

            // Replace current node with left subtree.
            if (node.right == null && node.left != null) {
                treeDetails.nodeRemoved();
                return node.left;
            }
        }

        if (value < node.value && node.left != null) {
            node.left = remove(value, node.left, treeDetails);
        } else if (value > node.value && node.right != null) {
            node.right = remove(value, node.right, treeDetails);
        }
        // Else, the node was not found.

        return node;
    }

    /**
     * Removes a node with min element from the subtree. {@code nodeValueHolder} will store min value.
     */
    public static Node removeMinElement(final Node node, final NodeValueHolder nodeValueHolder) {
        if (node.left != null) {
            node.left = removeMinElement(node.left, nodeValueHolder);
            return node;
        }

        nodeValueHolder.savedValue = node.value;
        return node.right;
    }

    /**
     * Removes a node with max element from the subtree. {@code nodeValueHolder} will store max value.
     */
    public static Node removeMaxElement(final Node node, final NodeValueHolder nodeValueHolder) {
        if (node.right != null) {
            node.right = removeMaxElement(node.right, nodeValueHolder);
        }

        nodeValueHolder.savedValue = node.value;
        return node.left;
    }

    /**
     * Holds value of a chosen node in a subtree.
     */
    public static class NodeValueHolder {
        private int savedValue;
    }
}
