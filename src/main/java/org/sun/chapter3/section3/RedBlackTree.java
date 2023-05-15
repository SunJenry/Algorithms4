package org.sun.chapter3.section3;

import org.sun.chapter3.section1.ST;

public class RedBlackTree<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int compare = key.compareTo(x.key);
            if (compare > 0) {
                x = x.right;
            } else if (compare < 0) {
                x = x.left;
            } else {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, key);

        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }

            if (key.compareTo(h.key) == 0 && (h.right == null)) {
                return null;
            }

            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }

            if (key.compareTo(h.key) == 0) {
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }

        return balance(h);
    }

    private Value get(Node h, Key key) {
        return null;
    }

    private Node min(Node h) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMin(root);

        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;

        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.N = size(node.left) + 1 + size(node.right);

        return node;
    }

    private Node moveRedLeft(Node h) {
        // Assuming that h is red and both h.left and h.left.left are black, make h.left or one of its children red.
        flipColors(h);

        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMax(root);

        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {

        if (isRed(h.left)) {
            h = rotateRight(h);
        }

        if (h.right == null) return null;

        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }

        h.right = deleteMax(h.right);

        return balance(h);
    }

    private Node moveRedRight(Node h) {
        //Assuming that h is red and both h.right and h.right.left are black, make h.right or one of its children red.
        flipColors(h);

        if (!isRed(h.left.left)) {
            h = rotateRight(h);
        }
        return h;
    }
}
