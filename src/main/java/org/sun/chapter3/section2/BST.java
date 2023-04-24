package org.sun.chapter3.section2;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter3.section1.ST;
import org.sun.util.StdOut;

public class BST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private class Node {
        private Key key;
        private Value value;

        private Node left, right;

        private int N;//#nodes in subtree rooted here.

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    private Node root;

    public BST() {
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int compare = x.key.compareTo(key);
        if (compare > 0) {
            put(x.left, key, value);
        } else if (compare < 0) {
            put(x.right, key, value);
        } else {
            x.value = value;
        }

        x.N = x.left.N + x.right.N + 1;
        return x;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int compare = x.key.compareTo(key);
        if (compare > 0) {
            return get(x.left, key);
        } else if (compare < 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = delete(x.left, key);
        } else if (compare > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    @Override
    public Key max() {
        return max(root);
    }

    private Key max(Node x) {
        if (x.right == null) return x.key;
        return max(x.right);
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare == 0) return x;
        if (compare < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare == 0) return x;
        if (compare > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return rank(x.left, key);
        } else if (compare > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }

    @Override
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        //return Node containing key of rank k
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> keys = new Queue<>();
        keys(keys, root, lo, hi);
        return keys;
    }

    private void keys(Queue<Key> keys, Node x, Key lo, Key hi) {
        if (x == null) return;
        int comLo = lo.compareTo(x.key);
        int comHi = hi.compareTo(x.key);

        if (comLo < 0) keys(keys, x.left, lo, hi);
        if (comLo <= 0 && comHi >= 0) keys.enqueue(x.key);
        if (comHi > 0) keys(keys, x.right, lo, hi);
    }

    public void print(Node x) {
        if (x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }
}
