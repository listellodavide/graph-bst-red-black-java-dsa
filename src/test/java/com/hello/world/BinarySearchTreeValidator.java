package com.hello.world;

import com.hello.world.bst.BSTNode;
import com.hello.world.bst.BinaryTree;

import java.math.BigInteger;

public final class BinarySearchTreeValidator {

    private BinarySearchTreeValidator() {}

    /**
     * Validates if the given binary tree is a binary search tree (with no duplicates allowed).
     *
     * @param tree the binary tree
     * @return whether the given binary tree is a binary search tree
     */
    public static boolean isBstWithoutDuplicates(BinaryTree tree) {
        return isBstWithoutDuplicates(tree.getRoot(), BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.valueOf(Integer.MAX_VALUE));
    }

    private static boolean isBstWithoutDuplicates(BSTNode node, BigInteger minAllowedKey, BigInteger maxAllowedKey) {
        if (node == null) {
            return true;
        }

        if (node.getData().getWeight().compareTo(minAllowedKey) < 0
                || node.getData().getWeight().compareTo(maxAllowedKey) > 0) {
            return false;
        }

        return isBstWithoutDuplicates(node.getLeft(), minAllowedKey, node.getData().getWeight().subtract(BigInteger.ONE))
                && isBstWithoutDuplicates(node.getRight(), node.getData().getWeight().add(BigInteger.ONE), maxAllowedKey);
    }

    /**
     * Validates if the given binary tree is a binary search tree (with duplicates allowed).
     *
     * @param tree the binary tree
     * @return whether the given binary tree is a binary search tree
     */
    public static boolean isBstWithDuplicates(BinaryTree tree) {
        return isBstWithDuplicates(tree.getRoot(), BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.valueOf(Integer.MAX_VALUE));
    }

    private static boolean isBstWithDuplicates(BSTNode node, BigInteger minAllowedKey, BigInteger maxAllowedKey) {
        if (node == null) {
            return true;
        }

        if (node.getData().getWeight().compareTo(minAllowedKey) < 0 || node.getData().getWeight().compareTo(maxAllowedKey) > 0 ) {
            return false;
        }

        return isBstWithDuplicates(node.getLeft(), minAllowedKey, node.getData().getWeight())
                && isBstWithDuplicates(node.getRight(), node.getData().getWeight(), maxAllowedKey);
    }
}
