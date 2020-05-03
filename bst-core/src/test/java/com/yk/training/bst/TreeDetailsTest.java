package com.yk.training.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeDetailsTest {

    @Test
    public void shouldTestTreeDetails() {
        TreeDetails treeDetails = new TreeDetails();
        treeDetails.nodeRemoved();
        assertTrue(treeDetails.wasNodeRemoved);

        treeDetails.reset();
        assertFalse(treeDetails.wasNodeRemoved);
    }
}