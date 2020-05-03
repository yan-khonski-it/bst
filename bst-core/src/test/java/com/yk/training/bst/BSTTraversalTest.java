package com.yk.training.bst;

import com.yk.training.bst.visitors.ValuesAccumulator;
import com.yk.training.bst.visitors.ValuesPrinter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.yk.training.bst.BSTTraversal.inorder;
import static com.yk.training.bst.BSTTraversal.postorder;
import static com.yk.training.bst.BSTTraversal.preorder;
import static com.yk.training.bst.samples.BSTSamples.treeH5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BSTTraversalTest {

    @Test
    public void shouldFailPreorderNull() {
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = Tree.ofValues(List.of());

        assertThrows(NullPointerException.class, () -> preorder(tree.root, valuesAccumulator));
    }

    @Test
    public void shouldPreorderRoot() {
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = Tree.ofRoot(5);

        preorder(tree.root, valuesAccumulator);
        assertEquals(List.of(5), valuesAccumulator.getAccumulatedValues());
    }

    @Test
    public void shouldPreorder() {
        List<Integer> expectedVisitedValues =
                List.of(30, 15, 10, 8, 6, 9, 11, 20, 17, 16, 18, 21, 40, 35, 32, 36, 45, 44, 47);
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = treeH5();

        preorder(tree.root, valuesAccumulator);
        assertEquals(expectedVisitedValues, valuesAccumulator.getAccumulatedValues());
    }

    @Test
    public void shouldFailInorderNull() {
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = Tree.ofValues(List.of());

        assertThrows(NullPointerException.class, () -> inorder(tree.root, valuesAccumulator));
    }

    @Test
    public void shouldInorderRoot() {
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = Tree.ofRoot(5);

        inorder(tree.root, valuesAccumulator);
        assertEquals(List.of(5), valuesAccumulator.getAccumulatedValues());
    }

    @Test
    public void shouldInorder() {
        List<Integer> expectedVisitedValues =
                List.of(6, 8, 9, 10, 11, 15, 16, 17, 18, 20, 21, 30, 32, 35, 36, 40, 44, 45, 47);
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = treeH5();

        inorder(tree.root, valuesAccumulator);
        assertEquals(expectedVisitedValues, valuesAccumulator.getAccumulatedValues());
    }

    @Test
    public void shouldFailPostorderNull() {
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = Tree.ofValues(List.of());

        assertThrows(NullPointerException.class, () -> postorder(tree.root, valuesAccumulator));
    }

    @Test
    public void shouldPostorderRoot() {
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = Tree.ofRoot(5);

        postorder(tree.root, valuesAccumulator);
        assertEquals(List.of(5), valuesAccumulator.getAccumulatedValues());
    }

    @Test
    public void shouldPostorder() {
        List<Integer> expectedVisitedValues =
                List.of(6, 9, 8, 11, 10, 16, 18, 17, 21, 20, 15, 32, 36, 35, 44, 47, 45, 40, 30);
        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        Tree tree = treeH5();

        postorder(tree.root, valuesAccumulator);
        assertEquals(expectedVisitedValues, valuesAccumulator.getAccumulatedValues());
    }

    /**
     * Covers default {@link ValuesPrinter}.
     */
    @Test
    public void shouldPrintTree() {
        Tree tree = treeH5();

        postorder(tree.root);
        preorder(tree.root);
        inorder(tree.root);
    }
}

