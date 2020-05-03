package com.yk.training.bst.visitors;

import com.yk.training.bst.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * Default {@link Node} {@code consumer}.
 * Prints nodes into default output.
 */
public class ValuesPrinter implements Consumer<Node> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValuesPrinter.class);

    @Override
    public void accept(final Node node) {
        LOGGER.info("{}", node.value);
    }
}
