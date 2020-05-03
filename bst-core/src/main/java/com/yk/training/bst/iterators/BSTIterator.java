package com.yk.training.bst.iterators;

import com.yk.training.bst.BSTTraversal;
import com.yk.training.bst.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Iterates a BST.
 * Check implementations: {@link BSTArrayIterator} and {@link BSTStackIterator}.
 */
public interface BSTIterator {

    boolean hasNext();

    int next();
}

/**
 * BST iterator which uses a list under the hood.
 * <p>
 * {@code hasNext()} - O(1),
 * {@code next()} - O(1).
 * However, it allocates O(n) internal memory before starting the iteration.
 * It stores all nodes in the array.
 */
class BSTArrayIterator implements BSTIterator {

    final List<Integer> values = new ArrayList<>();
    int currentIndex = 0;

    public BSTArrayIterator(final Node root) {
        if (root == null) {
            return;
        }

        BSTTraversal.inorder(root, node -> values.add(node.value));
    }

    @Override
    public boolean hasNext() {
        return currentIndex < values.size();
    }

    @Override
    public int next() {
        return values.get(currentIndex++);
    }
}

/**
 * BST iterator which uses a stack under the hood.
 * <p>
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * <p>
 * {@code hasNext()} - O(1), It checks if a stack is empty, which is O(1),
 * and left and right children have been visited: left subtree is always visited first,
 * see {@link BSTTraversal#inorder(Node, Consumer)}; therefore we do not check anything here.
 * If {@code currentNode} has a right child, it means that is has next.
 * <p>
 * {@code next()} - O(1), <b>on average</b>. In the worst case, it should remove all elements from the stack,
 * and then find next element of a node that has not been visited.
 * However, when stack has <b>k</b> elements,
 * it means that there were other {@code next()} calls at least <b>k</b> times.
 * And these calls would take O(1) time complexity: check left, right children, add an element into the stack.
 * Therefore, average complexity of <b>k</b> calls is O(1).
 *
 *
 */
class BSTStackIterator implements BSTIterator {

    final LinkedList<Node> stack = new LinkedList<>();

    Node currentNode;

    public BSTStackIterator(final Node root) {
        this.currentNode = root;
        if (root == null) {
            return;
        }

        navigateLeftSubtree();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public int next() {
        currentNode = stack.pop();
        final int currentValue = currentNode.value;

        if (currentNode.right != null) {
            // Push root of the right subtree into stack.
            currentNode = currentNode.right;
            navigateLeftSubtree();
        }

        return currentValue;
    }

    /**
     * Find next node to be returned in {@link #next()}.
     * Push it to stack.
     */
    public void navigateLeftSubtree() {
        stack.push(currentNode);

        while (currentNode.left != null) {
            currentNode = currentNode.left;
            stack.push(currentNode);
        }
    }
}