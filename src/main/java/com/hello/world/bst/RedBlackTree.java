package com.hello.world.bst;

import java.math.BigInteger;
import java.util.UUID;

/**
 * A red-black tree implementation with <code>T extends BasicDataType</code> keys.
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public class RedBlackTree<T extends BasicDataType> extends BaseBinaryTree implements BinarySearchTree<T>{

    static final boolean RED = false;
    static final boolean BLACK = true;

    @Override
    public BSTNode searchNode(T key) {
        BSTNode node = root;
        while (node != null) {
            if (key == node.data) {
                return node;
            } else if (key.isBigger(node.data)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    @Override
    public BSTNode searchNode(BigInteger weight) {
        BSTNode node = root;
        while (node != null) {
            if (weight == node.data.getWeight()) {
                return node;
            } else if (node.data.isBigger(weight)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;

    }

    @Override
    public BSTNode searchNode(UUID uuid) {
        BSTNode node = root;
        while (node != null) {
            if (uuid == node.data.getUuid()) {
                return node;
            } else if (node.data.isBigger(uuid)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    @Override
    public void insertNode(T key) {

        BSTNode node = root;
        BSTNode parent = null;

        // Traverse the tree to the left or right depending on the key
        while (node != null) {
            parent = node;
            if (key.isSmaller(node.data)) {
                node = node.left;
            } else if (key.isBigger(node.data)) {
                node = node.right;
            } else {
                throw new IllegalStateException("BST already contains a node with key: " + key);
            }
        }

        // insert the new node
        BSTNode newNode = new BSTNode(key);
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (key.isSmaller(parent.data)) {
            parent.left = newNode;
        } else {
            parent.right = parent;
        }
        newNode.parent = parent;

        rebalanceRedBlackPropertiesAfterInsert(newNode);
    }

    private void rebalanceRedBlackPropertiesAfterInsert(BSTNode node) {
        BSTNode parent = node.parent;

        // Case 1 : Parent is null, we have reached the root, the end of the recursion
        if (parent == null) {
            node.color = BLACK;
            return;
        }

        // parent is black --> nothing to do
        if (parent.color == BLACK) {
            return;
        }

        // from here on, parent is red
        BSTNode grandParent = parent.parent;

        // Case 2:
        // Not having a grandparent means that parent is the root. If we enforce black roots (rule2),
        // grandparent will never be null, and the following if-then block can be removed
        if (grandParent == null) {
            // as this method can only be called on red nodes (either on newly inserted ones, on recursively on red grad-parents,
            // all we have to do is to recolor the root to black.
            parent.color = BLACK;
            return;
        }

        // Get the uncle Bob (may-be null/nil, in which case its color is BLACK by definition
        BSTNode uncleBob = getUncleBob(parent);

        // Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncleBob != null && uncleBob.color == RED) {
            parent.color = BLACK;
            grandParent.color = RED;
            uncleBob.color = BLACK;

            // Call recursively for grandparent, which is now red.
            // It might be root or have a red parent, in which case we need to fix more ..
            rebalanceRedBlackPropertiesAfterInsert(grandParent);
        }

        // Note on performance:
        // It would be faster to do the uncle color check within the following code. This way
        // we would avoid checking the grandparent-parent direction twice (once in getUncle()
        // and once in the following else-if). But for better understanding of the code,
        // I left the uncle color check as a separate step.

        // Parent is left child of grandparent
        else if (parent == grandParent.left) {
            // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
            if (node == parent.right) {
                rotateLeft(parent);

                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we are going to fall-through to.
                parent = node;
            }

            // Case 5a: Uncle is black and node is left-right "outer child" of its grandparent
            rotateRight(grandParent);

            //Recolor original parent and grandparent
            parent.color = BLACK;
            grandParent.color = RED;

        }

        // Parent is right child of grandparent
        else {
            // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
            if (node == parent.left) {
                rotateRight(parent);

                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we are going to fall-through to.
                parent = node;
            }

            // Case 5b: Uncle is black and node is right-right: "outer child" of its grandparent
            rotateLeft(grandParent);

            // Recolor original parent and grandparent
            parent.color = BLACK;
            grandParent.color = RED;
        }
    }

    private BSTNode getUncleBob(BSTNode parent) {
        BSTNode grandparent = parent.parent;
        if (grandparent.left.equals(parent)) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent..cannot continue..");
        }
    }

    @Override
    public void deleteNode(T key) {
        BSTNode node = root;

        // Find the node to be deleted
        while (node != null && !node.data.equals(key)) {
            // Traverse the tree to the left or right depending on the key
            if (key.isSmaller(node.data)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // Node not found ?
        if (node == null) {
            return;
        }

        // At this point, "node" is the node to be deleted !
        // In this variable, we'll store the node at which we're going to start to fix the R-B
        // properties after deleting a node.

        BSTNode movedUpNode;
        boolean deletedNodeColor;

        //Node has zero or one child

        if (node.left == null || node.right == null) {
            movedUpNode = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }

        // Node has two children

        else {
            // Find minimum node or right subtree ("inorder successor" of current node)
            BSTNode inOrderSuccessor = findMinimum(node.right);

            // Copy inorder successor's data to current node (keep its color!)
            node.data = inOrderSuccessor.data;

            // Delete inorder successor just as we would delete a node with 0 or 1 child
            movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);

            // Remove the temporary NIL node
            if (movedUpNode.getClass() == NilNode.class) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }

    }

    private boolean isBlack(BSTNode node) {
        return node == null || node.color == BLACK;
    }

    private static class NilNode extends BSTNode {
        private NilNode() {
            super(new BasicDataType());
            this.color = BLACK;
        }
    }

    private void rotateRight(BSTNode node) {
        BSTNode parent = node.parent;
        BSTNode leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        replaceParentsChild(parent, node, leftChild);
    }

    private void rotateLeft(BSTNode node) {
        BSTNode parent = node.parent;
        BSTNode rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }

    private BSTNode deleteNodeWithZeroOrOneChild(BSTNode node) {
        // Node has ONLY a left child --> replace by its left child
        if (node.left != null) {
            replaceParentsChild(node.parent, node, node.left);
            return node.left; // moved-up node
        }

        // Node has ONLY a right child --> replace by its right child
        else if (node.right != null) {
            replaceParentsChild(node.parent, node, node.right);
            return node.right; // moved-up node
        }

        // Node has no children -->
        // * node is red --> just remove it
        // * node is black --> replace it by a temporary NIL node (needed to fix the R-B rules)
        else {
            BSTNode newChild = node.color == BLACK ? new NilNode() : null;
            replaceParentsChild(node.parent, node, newChild);
            return newChild;
        }
    }

    private BSTNode findMinimum(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @SuppressWarnings("squid:S125") // Ignore SonarCloud complains about commented code line 256.
    private void fixRedBlackPropertiesAfterDelete(BSTNode node) {
        // Case 1: Examined node is root, end of recursion
        if (node == root) {
            // Uncomment the following line if you want to enforce black roots (rule 2):
            // node.color = BLACK;
            return;
        }

        BSTNode sibling = getSibling(node);

        // Case 2: Red sibling
        if (sibling.color == RED) {
            handleRedSibling(node, sibling);
            sibling = getSibling(node); // Get new sibling for fall-through to cases 3-6
        }

        // Cases 3+4: Black sibling with two black children
        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = RED;

            // Case 3: Black sibling with two black children + red parent
            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            }

            // Case 4: Black sibling with two black children + black parent
            else {
                fixRedBlackPropertiesAfterDelete(node.parent);
            }
        }

        // Case 5+6: Black sibling with at least one red child
        else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    private void handleRedSibling(BSTNode node, BSTNode sibling) {
        // Recolor...
        sibling.color = BLACK;
        node.parent.color = RED;

        // ... and rotate
        if (node == node.parent.left) {
            rotateLeft(node.parent);
        } else {
            rotateRight(node.parent);
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(BSTNode node, BSTNode sibling) {
        boolean nodeIsLeftChild = node == node.parent.left;

        // Case 5: Black sibling with at least one red child + "outer nephew" is black
        // --> Recolor sibling and its child, and rotate around sibling
        if (nodeIsLeftChild && isBlack(sibling.right)) {
            sibling.left.color = BLACK;
            sibling.color = RED;
            rotateRight(sibling);
            sibling = node.parent.right;
        } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
            sibling.right.color = BLACK;
            sibling.color = RED;
            rotateLeft(sibling);
            sibling = node.parent.left;
        }

        // Fall-through to case 6...

        // Case 6: Black sibling with at least one red child + "outer nephew" is red
        // --> Recolor sibling + parent + sibling's child, and rotate around parent
        sibling.color = node.parent.color;
        node.parent.color = BLACK;
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    private BSTNode getSibling(BSTNode node) {
        BSTNode parent = node.parent;
        if (node == parent.left) {
            return parent.right;
        } else if (node == parent.right) {
            return parent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    private void replaceParentsChild(BSTNode parent, BSTNode oldChild, BSTNode newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

// -- For toString() -----------------------------------------------------------------------------

    @Override
    protected void appendNodeToString(BSTNode node, StringBuilder builder) {
        builder.append(node.data).append(node.color == RED ? "[R]" : "[B]");
    }

}