package com.yk.training.bst.tasks;

import com.yk.training.bst.BSTTraversal;
import com.yk.training.bst.Node;
import com.yk.training.bst.NodeDetails;
import com.yk.training.bst.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

import static com.yk.training.bst.samples.BSTSamples.treeH5;

/**
 * Mark each node with level of this node.
 * Node, root has level 1.
 * <p>
 * Solution, when we perform a {@link BSTTraversal#preorder(Node, Consumer)} operation, we pass root level as 1.
 * For next nodes, we pass previous level + 1.
 * When {@code preorder} operation finishes, we decrement current level.
 */
public class MarkNodesWithLevel {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarkNodesWithLevel.class);

    public static void main(final String[] args) {
        final Tree tree = treeH5();
        final NodeLevelVisitor nodeLevelVisitor = new NodeLevelVisitor();
        preorder(tree.root, nodeLevelVisitor.levelUp());

        // Print the tree
        BSTTraversal.preorder(tree.root, node -> LOGGER.info("{} {}", node.value, node.nodeDetails.getLevel()));
    }

    /**
     * A modification {@link BSTTraversal#preorder(Node, Consumer)}
     * to mark a {@link Node} with level in its {@link Tree}.
     * Root has level 1.
     */
    public static void preorder(final Node node, final NodeLevelVisitor visitor) {
        visitor.accept(node);

        if (node.left != null) {
            preorder(node.left, visitor.levelUp());
        }

        if (node.right != null) {
            preorder(node.right, visitor.levelUp());
        }

        visitor.levelDown();
    }

    /**
     * Visits a {@link Node} and marks its level.
     */
    private static class NodeLevelVisitor implements Consumer<Node> {

        int level = 0;

        @Override
        public void accept(final Node node) {
            node.nodeDetails = NodeDetails.of(level);
        }

        public NodeLevelVisitor levelUp() {
            level++;
            return this;
        }

        @SuppressWarnings("UnusedReturnValue")
        public NodeLevelVisitor levelDown() {
            level--;
            return this;
        }
    }
}


