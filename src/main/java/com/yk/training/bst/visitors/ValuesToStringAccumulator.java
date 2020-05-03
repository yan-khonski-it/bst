package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;

import java.util.function.Consumer;

/**
 * Accumulates {@link Node}s into String.
 */
public class ValuesToStringAccumulator implements Consumer<Node> {

    private final StringBuilder sb = new StringBuilder();
    private String separator = ", ";

    @Override
    public void accept(Node node) {
        if (sb.length() == 0) {
            sb.append(node.value);
        } else {
            sb.append(separator).append(node.value);
        }
    }

    public String getResult() {
        return sb.toString();
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
