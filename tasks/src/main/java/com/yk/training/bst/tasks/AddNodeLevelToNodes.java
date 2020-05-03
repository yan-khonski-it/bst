package com.yk.training.bst.tasks;

import com.yk.training.bst.BSTTraversal;
import com.yk.training.bst.Node;
import com.yk.training.bst.NodeDetails;
import com.yk.training.bst.Tree;

import java.util.function.Consumer;

import static com.yk.training.bst.samples.BSTSamples.treeH5;

/**
 * Mark each node with level of this node.
 * Node, root has level 1.
 */
public class AddNodeLevelToNodes {

    public static void main(String[] args) {
        final Tree tree = treeH5();
        final NodeLevelVisitor nodeLevelVisitor = new NodeLevelVisitor();
        preorder(tree.root, nodeLevelVisitor.levelUp());

        // Print the tree
        BSTTraversal.preorder(tree.root, node -> System.out.println(node.value + " " + node.nodeDetails.getLevel()));
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
}

class NodeLevelVisitor implements Consumer<Node> {

    int level = 0;

    @Override
    public void accept(Node node) {
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
