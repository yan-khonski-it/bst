package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;

import java.util.function.Consumer;

public class ValuesPrinter implements Consumer<Node> {

    @Override
    public void accept(Node node) {
        System.out.println(node.value);
    }
}
