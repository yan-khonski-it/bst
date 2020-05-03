package com.yk.training.bst.iterators;

import com.yk.training.bst.BSTTraversal;
import com.yk.training.bst.Tree;
import com.yk.training.bst.visitors.ValuesAccumulator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.yk.training.bst.samples.BSTSamples.treeH5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BSTIteratorTest {

    @Test
    public void shouldNotIterateEmptyTreeWithArray() {
        BSTIterator iterator = new BSTArrayIterator(Tree.empty().root);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldOnceIterateRootTreeWithArray() {
        Tree tree = Tree.ofRoot(6);
        BSTIterator iterator = new BSTArrayIterator(tree.root);

        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldIterateWithArray() {
        Tree tree = treeH5();
        BSTIterator iterator = new BSTArrayIterator(tree.root);
        List<Integer> iteratedValues = new ArrayList<>();
        while (iterator.hasNext()) {
            iteratedValues.add(iterator.next());
        }

        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        BSTTraversal.inorder(tree.root, valuesAccumulator);

        assertEquals(valuesAccumulator.getAccumulatedValues(), iteratedValues);
    }

    @Test
    public void shouldNotIterateEmptyTreeWithStack() {
        BSTIterator iterator = new BSTStackIterator(Tree.empty().root);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldOnceIterateRootTreeWithStack() {
        Tree tree = Tree.ofRoot(6);
        BSTIterator iterator = new BSTStackIterator(tree.root);

        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldIterateWithStack() {
        Tree tree = treeH5();
        BSTIterator iterator = new BSTStackIterator(tree.root);
        List<Integer> iteratedValues = new ArrayList<>();
        while (iterator.hasNext()) {
            iteratedValues.add(iterator.next());
        }

        ValuesAccumulator valuesAccumulator = new ValuesAccumulator();
        BSTTraversal.inorder(tree.root, valuesAccumulator);

        assertEquals(valuesAccumulator.getAccumulatedValues(), iteratedValues);
    }
}