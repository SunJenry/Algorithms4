package org.sun.chapter3.section1;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    public OrderedSequentialSearchST() {
    }

    @Override
    public void put(Key key, Value value) {
        if (first == null) {
            first = new Node(key, value, null);
        } else if (key.compareTo(first.key) > 0) {
            first = new Node(key, value, first);
        } else {
            //update or add new node
            Node current = first;
            Node next = current.next;

            while (current != null) {
                int compare = current.key.compareTo(key);
                if (compare == 0) {
                    current.value = value;
                    break;
                } else if (compare > 0) {
                    if (next != null) {
                        if (next.key.compareTo(key) < 0) {
                            //insert
                            current.next = new Node(key, value, next);
                            break;
                        }
                    } else {
                        //insert last
                        current.next = new Node(key, value, null);
                        break;
                    }
                }

                current = next;
                if (current != null) {
                    next = current.next;
                }
            }
        }
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

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
}
