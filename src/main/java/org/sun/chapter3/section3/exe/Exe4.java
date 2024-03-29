package org.sun.chapter3.section3.exe;

public class Exe4 {
    /**
     * Proposition: The height of a 2-3 tree with N keys is between ~log3 N ~ .63 lg N (for a tree that is all 3-nodes)
     * and ~lg N (for a tree that is all 2 nodes).
     *
     * Proof: The height of a tree is equal to the maximum number of compares between the root and a leaf node.
     * When a 2-3 tree has all its nodes as 3-nodes, the maximum number of compares between the root and a leaf node
     * will be ~log3 N because after each compare only 1/3 of the remaining nodes are considered for further comparisons.
     * When a 2-3 tree has all its nodes as 2-nodes, the maximum number of compares between the root and a leaf node
     * will be ~lg N because after each compare only 1/2 of the remaining nodes are considered for further comparisons.
     * So the height of a 2-3 tree with N keys will be between ~log3 N and ~lg N.
     */
}
