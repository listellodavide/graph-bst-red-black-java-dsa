package com.hello.world.bst;


/**
 * A BSTNode class contain a Node representation
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public class BSTNode<T extends BasicDataType> {

    T data;

    BSTNode left;
    BSTNode right;
    BSTNode parent;

    boolean color;

    public BSTNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public BSTNode getParent() {
        return parent;
    }

    public boolean isColor() {
        return color;
    }
}
