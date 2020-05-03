package com.yk.training.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeTest {

    @Test
    public void shouldTestNode() {
        Node node = new Node(5);
        assertTrue(node.isLeave());
        assertFalse(node.hasBothChildren());

        node.right = new Node(6);
        assertFalse(node.isLeave());
        assertFalse(node.hasBothChildren());

        node.left = new Node(3);
        assertFalse(node.isLeave());
        assertTrue(node.hasBothChildren());
    }
}