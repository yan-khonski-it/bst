package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;

import java.util.function.Consumer;

public class ValuesToStringAccumulator implements Consumer<Node> {

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void accept(Node node) {
        if (sb.length() == 0) {
            sb.append(node.value);
        } else {
            sb.append(", ").append(node.value);
        }
    }

    public String getResult() {
        return sb.toString();
    }
}
