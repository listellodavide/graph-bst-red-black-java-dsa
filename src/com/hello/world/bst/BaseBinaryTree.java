package com.hello.world.bst;

/**
 * A BaseBinaryTree implementation
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public class BaseBinaryTree implements BinaryTree {

    protected BSTNode root;

    @Override
    public BSTNode getRoot() {
        return root;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        appendNodeToStringRecursive(getRoot(), builder);
        return builder.toString();
    }

    private void appendNodeToStringRecursive(BSTNode node, StringBuilder builder) {
        appendNodeToString(node, builder);
        if (node.left != null) {
            builder.append(" L{");
            appendNodeToStringRecursive(node.left, builder);
            builder.append('}');
        }
        if (node.right != null) {
            builder.append(" R{");
            appendNodeToStringRecursive(node.right, builder);
            builder.append('}');
        }
    }

    protected void appendNodeToString(BSTNode node, StringBuilder builder) {
        builder.append(node.data);
    }
}
