package com.hello.world.bst;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;
/**
 * A red-black tree implementation with <code>T extends BasicDataType</code> keys.
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public class RedBlackTree<T extends BasicDataType> extends BaseBinaryTree implements BinarySearchTree {

    static final boolean RED = false;
    static final boolean BLACK = true;

    @Override
    public BSTNode searchNode(T key) {
        BSTNode node = root;
        while(node != null) {
            if( key == node.data) {
                return node;
            }
            else if (key.isBigger(node.data)) {
                node = node.left;
            }
            else {
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
        while(node != null) {
            parent = node;
            if(key.isSmaller(node.data)) {
                node = node.left;
            }
            else if (key.isBigger(node.data)) {
                node = node.right;
            }
            // @fixme! we come back shortly after the break..
        }

    }

    @Override
    public void deleteNode(T key) {

    }

    @Override
    public ExpressionTree getLeftOperand() {
        return null;
    }

    @Override
    public ExpressionTree getRightOperand() {
        return null;
    }

    @Override
    public Kind getKind() {
        return null;
    }

    @Override
    public R accept(TreeVisitor<R, D> visitor, D data) {
        return null;
    }
}
