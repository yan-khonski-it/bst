package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;

import java.util.function.Consumer;

/**
 * Default {@link Node} {@code consumer}.
 * Prints nodes into default output.
 */
public class ValuesPrinter implements Consumer<Node> {

    @Override
    public void accept(Node node) {
        System.out.println(node.value);
    }
}
