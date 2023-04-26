package org.sun.chapter3.section2.exe;

import org.sun.chapter3.section2.BinarySearchTree;

public class Exe15 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param values must be sorted!!!
     * @param binarySearchTree
     * @param low
     * @param high
     */
    private void insertPerfectValue(int[] values, BinarySearchTree<Integer, Integer> binarySearchTree, int low, int high) {
        if (high < low) return;

        int mid = (low + high) / 2;

        binarySearchTree.put(values[mid], values[mid]);

        insertPerfectValue(values, binarySearchTree, low, mid - 1);
        insertPerfectValue(values, binarySearchTree, mid + 1, high);
    }
}
