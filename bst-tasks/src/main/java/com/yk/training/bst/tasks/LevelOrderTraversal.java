package com.yk.training.bst.tasks;

import com.yk.training.bst.BSTTraversal;
import com.yk.training.bst.Node;
import com.yk.training.bst.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.yk.training.bst.samples.BSTSamples.treeH5;

/**
 * Traverses a binary search tree, and output it into a 2D array where i-array is i - level nodes.
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * <p>
 * Solution, start with {@link MarkNodesWithLevel}.
 * It can be done in one iteration,
 * so complexity is O(n) - iterate through N elements of the tree;
 * and memory complexity is O(N) - we need to store 2D array of elements, but their total size is N.
 * <p>
 * When we visit a node, we can store node value and its level.
 * We store nodes levels into a 2D array, where i-th element of the array is an array of nodes values for level i.
 */
public class LevelOrderTraversal {

    public static void main(final String[] args) {
        final Tree tree = treeH5();
        final NodeLevelMapVisitor nodeLevelMapVisitor = new NodeLevelMapVisitor();
        preorder(tree.root, nodeLevelMapVisitor.levelUp());

        for (int i = 0; i < nodeLevelMapVisitor.levelNodes.size(); i++) {
            System.out.println(nodeLevelMapVisitor.levelNodes.get(i));
        }
    }

    /**
     * A modification {@link BSTTraversal#preorder(Node, Consumer)}
     * to mark a {@link Node} with level in its {@link Tree}.
     * Root has level 1.
     */
    public static void preorder(final Node node, final NodeLevelMapVisitor visitor) {
        visitor.accept(node);

        if (node.left != null) {
            preorder(node.left, visitor.levelUp());
        }

        if (node.right != null) {
            preorder(node.right, visitor.levelUp());
        }

        visitor.levelDown();
    }


    /**
     * Stores nodes value into {@code levelNodes} i-th array, where i is a node level.
     */
    private static class NodeLevelMapVisitor implements Consumer<Node> {

        int level = 0;
        List<List<Integer>> levelNodes = new ArrayList<>();

        @Override
        public void accept(final Node node) {
            if (levelNodes.size() < level) {
                levelNodes.add(new ArrayList<>());
            }

            levelNodes.get(level - 1).add(node.value);
        }

        public NodeLevelMapVisitor levelUp() {
            level++;
            return this;
        }

        @SuppressWarnings("UnusedReturnValue")
        public NodeLevelMapVisitor levelDown() {
            level--;
            return this;
        }
    }
}

