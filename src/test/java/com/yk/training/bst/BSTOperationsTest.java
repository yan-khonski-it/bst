package com.yk.training.bst;

import org.junit.jupiter.api.Test;

import static com.yk.training.bst.BSTOperations.add;
import static com.yk.training.bst.BSTOperations.max;
import static com.yk.training.bst.BSTOperations.min;
import static com.yk.training.bst.BSTOperations.search;
import static com.yk.training.bst.samples.BSTSamples.treeH5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BSTOperationsTest {

    @Test
    public void shouldSearchNodes() {
        Tree tree = treeH5();

        assertNull(search(0, tree.root));
        assertNull(search(3, tree.root));
        assertNull(search(50, tree.root));
        assertNull(search(14, tree.root));

        Node root = search(30, tree.root);
        assertNotNull(root);
        assertEquals(tree.root.value, root.value);

        Node node15 = search(15, tree.root);
        assertNotNull(node15);
        assertEquals(15, node15.value);

        Node node16 = search(16, tree.root);
        assertNotNull(node16);
        assertEquals(16, node16.value);

        Node node45 = search(45, tree.root);
        assertNotNull(node45);
        assertEquals(45, node45.value);
    }

    @Test
    public void shouldSearchEmptyTree() {
        Tree tree = Tree.empty();
        assertThrows(NullPointerException.class, () -> search(3, tree.root));

        Tree singleNode = Tree.ofRoot(4);
        Node foundNode4 = search(4, singleNode.root);
        assertNotNull(foundNode4);
        assertEquals(4, foundNode4.value);

        assertNull(search(5, singleNode.root));
    }

    @Test
    public void shouldFindMax() {
        Tree tree = treeH5();

        Node node = max(tree.root);
        assertEquals(47, node.value);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void shouldFindMaxInEmptyTree() {
        Tree tree = Tree.empty();

        assertThrows(NullPointerException.class, () -> max(tree.root));
    }

    @Test
    public void shouldFindMaxInRoot() {
        Tree tree = Tree.ofRoot(4);

        Node node = max(tree.root);
        assertEquals(4, node.value);
    }

    @Test
    public void shouldFindMin() {
        Tree tree = treeH5();

        Node node = min(tree.root);
        assertEquals(6, node.value);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void shouldFindMinInEmptyTree() {
        Tree tree = Tree.empty();

        assertThrows(NullPointerException.class, () -> min(tree.root));
    }

    @Test
    public void shouldFindMinInRoot() {
        Tree tree = Tree.ofRoot(4);

        Node node = min(tree.root);
        assertEquals(4, node.value);
    }

    @Test
    public void shouldAddNode() {
        Tree emptyTree = Tree.empty();
        assertThrows(NullPointerException.class, () -> add(1, emptyTree.root));

        Tree treeLeafLeft = Tree.ofRoot(5);
        add(1, treeLeafLeft.root);
        assertNotNull(treeLeafLeft.root.left);
        assertNull(treeLeafLeft.root.right);
        assertEquals(1, treeLeafLeft.root.left.value);

        Tree treeLeafRight = Tree.ofRoot(5);
        add(6, treeLeafRight.root);
        assertNotNull(treeLeafRight.root.right);
        assertNull(treeLeafRight.root.left);
        assertEquals(6, treeLeafRight.root.right.value);

        Tree tree = treeH5();
        add(22, tree.root);
        assertNotNull(tree.root.left.right.right.right);
        assertEquals(22, tree.root.left.right.right.right.value);
    }
}