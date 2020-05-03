package com.yk.training.bst.iterators;

import com.yk.training.bst.BSTTraversal;
import com.yk.training.bst.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterates a BST.
 * <p>
 * TODO Add optimized iterator which uses O(h) internal memory
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {

    public boolean hasNext() {
        return true;
    }

    public int next() {
        return 0;
    }
}

/**
 * BST iterator which uses a list under the hood.
 * <p>
 * {@code hasNext()} - O(1),
 * {@code next()} - O(1).
 * However, it allocates O(n) internal memory before starting the iteration.
 */
class BSTArrayIterator extends BSTIterator {

    final List<Integer> values = new ArrayList<>();
    int currentIndex = 0;

    public BSTArrayIterator(final Node root) {
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