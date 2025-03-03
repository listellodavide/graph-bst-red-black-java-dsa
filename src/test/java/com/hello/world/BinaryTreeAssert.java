package com.hello.world;

import com.hello.world.bst.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class BinaryTreeAssert {

    private final BinaryTree tree;

    private BinaryTreeAssert(BinaryTree tree) {
        this.tree = tree;
    }

    public static BinaryTreeAssert assertThatTree(BinarySearchTree tree) {
        return new BinaryTreeAssert(tree);
    }

    public BinaryTreeAssert isValid() {
        if (!BinarySearchTreeValidator.isBstWithoutDuplicates(tree)) {
            throw new AssertionError("Tree is not a valid BST");
        }
        return this;
    }

    public BinaryTreeAssert hasKeysInGivenOrder(List<Student> keys) {
        TestNodeVisitor visitor = new TestNodeVisitor();
        new DepthFirstTraversalRecursive(tree).traverseInOrder(visitor);
        assertThat(visitor.getDataList(), is(keys));
        return this;
    }

    public BinaryTreeAssert hasAllParentsSetCorrectly() {
        hasAllParentsSetCorrectly(null, tree.getRoot());
        return this;
    }

    private void hasAllParentsSetCorrectly(BSTNode parent, BSTNode node) {
        if (node == null) return;

        // Root must not have a parent
        if (node == tree.getRoot()) {
            if (node.getParent() != null) {
                throw new AssertionError("Not all parents set correctly: root must not have a parent");
            }
        }

        // All other nodes must have a parent
        else {
            if (node.getParent() == null) {
                throw new AssertionError(
                        "Not all parents set correctly: node " + node.getData() + " has no parent");
            }

            if (node.getParent() != parent) {
                throw new AssertionError(
                        "Not all parents set correctly: parent "
                                + node.getParent().getData()
                                + " of node "
                                + node.getData()
                                + " isn't the expected parent "
                                + parent.getData());
            }
        }

        hasAllParentsSetCorrectly(node, node.getLeft());
        hasAllParentsSetCorrectly(node, node.getRight());
    }
}
