package org.sun.chapter3.section2;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter3.section1.ST;
import org.sun.util.StdOut;

/**
 * binary search tree (BST) is a binary tree where each node has a Comparable key (and an associated value) and
 * satisfies the restriction that the key in any node is larger than the keys in all nodes that node's left subtree and
 * smaller than the keys in all nodes in that node's right subtree.
 * <p>
 * Proposition C. Search hits in a BST built from N random keys requires ~2lnN (about 1.39lgN) compares, on the average.
 * <p>
 * Proposition D. Insertions and search misses in a BST built from N random keys requires ~2lnN (about 1.39lnN) compares,
 * on the average.
 * <p>
 * Proposition E. In a BST, all operations take time propositional to the height of the tree, in the worst case.
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private class Node {
        private Key key;
        private Value value;
        private int N;
        private Node left, right;
        private int height;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    private Node cache;

    @Override
    public void put(Key key, Value value) {
        if (cache != null && cache.key.equals(key)) {
            cache.value = value;
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            Node node = new Node(key, value, 1);
            cache = node;
            return node;
        }

        int compare = key.compareTo(x.key);
        if (compare > 0) {
            x.right = put(x.right, key, value);
        } else if (compare < 0) {
            x.left = put(x.left, key, value);
        } else {
            cache = x;
            x.value = value;
        }

        x.N = size(x.left) + size(x.right) + 1;

        x.height = Math.max(heightRecursive(x.left), heightNoRecursive(x.right)) + 1;

        return x;
    }

    @Override
    public Value get(Key key) {
        if (cache != null && cache.key.equals(key)) {
            return cache.value;
        }
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare > 0) {
            return get(x.right, key);
        } else if (compare < 0) {
            return get(x.left, key);
        } else {
            cache = x;
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

        if (compare > 0) {
            x.right = delete(x.right, key);
        } else if (compare < 0) {
            x.left = delete(x.left, key);
        } else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(heightNoRecursive(x.left), heightNoRecursive(x.right)) + 1;

        return x;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
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
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;

        int compare = key.compareTo(x.key);

        if (compare == 0) return x;
        if (compare < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        return x;
    }

    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare == 0) return x;
        if (compare > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) {
            return t;
        }
        return x;
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int compare = key.compareTo(x.key);
        if (compare > 0) {
            return rank(x.right, key) + size(x.left) + 1;
        } else if (compare < 0) {
            return rank(x.left, key);
        } else {
            return x.N;
        }
    }

    @Override
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        int compare = k - x.N;
        if (compare == 0) {
            return x;
        } else if (compare < 0) {
            return select(x.left, k);
        } else {
            return select(x.right, k - x.N - 1);
        }
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(heightNoRecursive(x.left), heightNoRecursive(x.right)) + 1;
        return x;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(heightNoRecursive(x.left), heightNoRecursive(x.right)) + 1;
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
        int compareLo = x.key.compareTo(lo);
        int compareHi = x.key.compareTo(hi);

        if (compareLo < 0) {
            keys(keys, x.right, lo, hi);
        }

        if (compareHi > 0) {
            keys(keys, x.left, lo, hi);
        }

        if (compareLo >= 0 && compareHi <= 0) {
            keys.enqueue(x.key);
        }
    }

    public void print(Node x) {
        if (x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }

    public int heightNoRecursive() {
        return heightNoRecursive(root);
    }

    private int heightNoRecursive(Node x) {
        if (x == null) return 0;
        return x.height;
    }

    public int heightRecursive() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node x) {
        if (x == null) return 0;

        return Math.max(heightRecursive(x.left), heightRecursive(x.right)) + 1;
    }

    public Value getNoRecursive(Key key) {
        Node x = root;
        while (x != null) {
            int compare = key.compareTo(x.key);
            if (compare == 0) return x.value;
            else if (compare > 0) x = x.right;
            else if (compare < 0) x = x.left;
        }
        return null;
    }

    public void putNoRecursive(Key key, Value value) {
        Node x = root;

        if (x == null) {
            root = new Node(key, value, 1);
        }

        while (x != null) {
            int compare = key.compareTo(x.key);
            if (compare == 0) {
                x.value = value;
                return;
            } else if (compare > 0) {
                x = x.right;
            } else {
                x = x.left;
            }
        }

        x = root;

        while (true) {
            int compare = key.compareTo(x.key);
            x.N++;
            if (compare > 0) {
                if (x.right != null) {
                    x = x.right;
                } else {
                    x.right = new Node(key, value, 1);
                    break;
                }
            } else if (compare < 0) {
                if (x.left != null) {
                    x = x.left;
                } else {
                    x.left = new Node(key, value, 1);
                    break;
                }
            }
        }
    }

}
