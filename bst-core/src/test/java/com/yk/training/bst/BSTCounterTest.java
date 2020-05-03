package com.yk.training.bst;

import org.junit.jupiter.api.Test;

import static com.yk.training.bst.BSTCounter.height;
import static com.yk.training.bst.BSTCounter.leaves;
import static com.yk.training.bst.BSTCounter.totalNodes;
import static com.yk.training.bst.samples.BSTSamples.treeH5;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BSTCounterTest {

    @Test
    public void shouldCountNodes() {
        Tree tree = treeH5();

        int totalNodes = totalNodes(tree.root);
        assertEquals(19, totalNodes);
    }

    @Test
    public void shouldCount0NodesForEmptyTree() {
        Tree tree = Tree.empty();
        assertEquals(0, totalNodes(tree.root));
    }

    @Test
    public void shouldCount1NodeForLeaf() {
        Tree tree = Tree.ofRoot(5);
        assertEquals(1, totalNodes(tree.root));
    }

    @Test
    public void shouldCountLeaves() {
        Tree tree = treeH5();

        int totalLeaves = leaves(tree.root);
        assertEquals(10, totalLeaves);
    }

    @Test
    public void shouldCount0LeavesForEmptyTree() {
        Tree tree = Tree.empty();
        assertEquals(0, leaves(tree.root));
    }

    @Test
    public void shouldCount1LeafForLeaf() {
        Tree tree = Tree.ofRoot(5);
        assertEquals(1, leaves(tree.root));
    }

    @Test
    public void shouldReturnHeight() {
        Tree tree = treeH5();

        int height = height(tree.root);
        assertEquals(5, height);
    }

    @Test
    public void shouldReturnHeight0ForEmptyTree() {
        Tree tree = Tree.empty();
        assertEquals(0, height(tree.root));
    }

    @Test
    public void shouldReturnHeight1ForLeaf() {
        Tree tree = Tree.ofRoot(5);
        assertEquals(1, height(tree.root));
    }
}