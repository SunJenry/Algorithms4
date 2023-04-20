package org.sun.chapter3;

public class SequentialSearchST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private Node first;
    private int size;


    public SequentialSearchST() {

    }

    @Override
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = value;
                return;
            }
        }

        first = new Node(key, value, first);
        size++;
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (isEmpty()) return;

        if (first.key.equals(key)) {
            first = first.next;
            size--;
        } else {
            Node pre = first;
            Node current = pre.next;

            while (current != null) {

                if (current.key.equals(key)) {
                    pre.next = current.next;
                    size--;
                    break;
                }

                pre = current;
                current = pre.next;
            }
        }
    }

    @Override
    public int size() {
        return size;
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

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
