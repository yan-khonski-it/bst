package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;
import com.yk.training.bst.BSTTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Accumulates nodes into list in traversal. {@link BSTTraversal}.
 */
public class ValuesAccumulator implements Consumer<Node> {

    private final List<Integer> accumulatedValues = new ArrayList<>();

    @Override
    public void accept(Node node) {
        accumulatedValues.add(node.value);
    }

    public List<Integer> getAccumulatedValues() {
        return accumulatedValues;
    }
}
