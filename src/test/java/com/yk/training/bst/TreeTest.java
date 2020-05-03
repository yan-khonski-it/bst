package com.yk.training.bst;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeTest {

    @Test
    public void shouldBuildEmptyTree() {
        Tree empty = Tree.empty();
        assertNull(empty.root);
        assertTrue(empty.isEmpty());
        assertFalse(empty.isSingleNode());
    }

    @Test
    public void shouldBuildSingleNodeTree() {
        Node singleNodeTree = Tree.ofRoot(5).root;
        Node singleNodeTree1 = Tree.ofValues(List.of(5)).root;

        assertTrue(singleNodeTree.isLeave());
        assertEquals(5, singleNodeTree.value);

        assertTrue(singleNodeTree1.isLeave());
        assertEquals(5, singleNodeTree1.value);
    }

    @Test
    public void shouldBuildTreeOfEmptyValues() {
        assertNull(Tree.ofValues(List.of()).root);
    }

    @Test
    public void shouldFailToBuildTreeOfNullValues() {
        assertThrows(NullPointerException.class, () -> Tree.ofValues(null));
    }
}