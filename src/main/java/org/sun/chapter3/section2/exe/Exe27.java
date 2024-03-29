package org.sun.chapter3.section2.exe;

public class Exe27 {
    /**
     * 3.2.27 - Memory usage
     *
     * * BST
     *    object overhead -> 16 bytes
     *    Node reference (root) -> 8 bytes
     *    Node
     *       object overhead -> 16 bytes
     *       extra overhead for reference to the enclosing instance -> 8 bytes
     *       Key reference (key) -> 8 bytes
     *       Value reference (value) -> 8 bytes
     *       Node reference (left) -> 8 bytes
     *       Node reference (right) -> 8 bytes
     *       int value (size) -> 4 bytes
     *       padding -> 4 bytes
     *             (N Node references -> 64N bytes)
     * Amount of memory needed: 16 + 8 + (16 + 8 + 8 + 8 + 8 + 8 + 4 + 4)N = 64N + 24 bytes
     *
     * * BinarySearchST
     *    object overhead -> 16 bytes
     *    Key[] reference (keys) -> 8 bytes
     *    Value[] reference (values) -> 8 bytes
     *    int value (size) -> 4 bytes
     *    padding -> 4 bytes
     *    Key[]
     *       object overhead -> 16 bytes
     *       int value (length) -> 4 bytes
     *       padding -> 4 bytes
     *       N Key references -> between 8N and 32N bytes (the resizing array may be 25% to 100% full)
     *    Value[]
     *       object overhead -> 16 bytes
     *       int value (length) -> 4 bytes
     *       padding -> 4 bytes
     *       N Value references -> between 8N and 32N bytes (the resizing array may be 25% to 100% full)
     * Amount of memory needed: 16 + 8 + 8 + 4 + 4 + 16 + 4 + 4 + (8N to 32N) + 16 + 4 + 4 + (8N to 32N) = (16N to 64N) + 88 bytes
     *
     * * SequentialSearchST
     *    object overhead -> 16 bytes
     *    Node reference (first) -> 8 bytes
     *    Node
     *       object overhead -> 16 bytes
     *       extra overhead for reference to the enclosing instance -> 8 bytes
     *       Key reference (key) -> 8 bytes
     *       Value reference (value) -> 8 bytes
     *       Node reference (next) -> 8 bytes
     *             (N Node references -> 48N bytes)
     *    int value (size) -> 4 bytes
     *    padding -> 4 bytes
     * Amount of memory needed: 16 + 8 + (16 + 8 + 8 + 8 + 8)N + 4 + 4 = 48N + 32 bytes
     *
     *
     * String object (Java 7 and later) = 56 + 2C bytes, where C is the number of characters in its char[] array
     * Integer object = 24 bytes
     *
     * Memory usage of a BST with String keys and Integer values: 64N + 24 bytes (BST) + (56 + 2C bytes + 24 bytes) * N
     * = 64N + 24 + (80 + 2C) * N bytes = 2CN + 144N + 24 bytes
     *
     * Diagram
     *
     * Assuming an average of 5 characters per String, the BST uses 2CN + 144N + 24 = 10N + 144N + 24 = 154N + 24 bytes
     *
     *     Memory usage (bytes)
     *              15,400,024 |                                                         *
     *                 154,024 |                              *
     *                  15,424 |      *
     *                         -------------------------------------------------------------
     * Number of keys/values   0     100                     1000                     100000
     *
     * Tale of Two Cities has 135,938 words and 760,934 characters.
     * That is an average of ~6 characters per String key.
     * The memory usage for the BST built when FrenquencyCounter uses BST for Tale of Two Cities is:
     * 2 * 6 * N + 144N + 24 = 156N + 24 = (156 * 135,938) + 24 = 21,206,352 bytes
     */
}
