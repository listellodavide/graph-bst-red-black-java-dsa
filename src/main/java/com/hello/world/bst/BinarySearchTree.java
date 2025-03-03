package com.hello.world.bst;

import java.math.BigInteger;
import java.util.UUID;

/**
 * A BinarySearchTree interface
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public interface BinarySearchTree<T extends BasicDataType> extends BinaryTree {

    /**
     * Searches for a node with the given search key.
     *
     * @param key the search key
     * @return the node or <code>null</code> if no node with the given search key exists
     */
    BSTNode searchNode(T key);


    BSTNode searchNode(BigInteger weight);


    BSTNode searchNode(UUID uuid);
    /**
     * Inserts a node with the given key.
     *
     * @param key the key of the node to be inserted
     */
    void insertNode(T key);

    /**
     * Deletes the node with the given key.
     *
     * @param key the key of the node to be deleted
     */
    void deleteNode(T key);
}
