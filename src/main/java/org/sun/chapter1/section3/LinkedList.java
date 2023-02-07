package org.sun.chapter1.section3;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int size;
    private Node first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node getFirst() {
        return first;
    }

    public void insert(Item item) {
        if (first == null) {
            first = new Node();
            first.item = item;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }

            Node node = new Node();
            node.item = item;
            current.next = node;
        }

        size++;
    }

    public Item get(int index) {
        if (isEmpty()) {
            return null;
        }

        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index must be between 0 and " + (size() - 1));
        }

        int currentIndex = 0;
        Node node = first;
        while (currentIndex < index) {
            node = node.next;
            currentIndex++;
        }

        return node.item;
    }

    public void remove(int index) {

        if (isEmpty()) {
            return;
        }

        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index must be between 0 and " + (size() - 1));
        }

        if (index == 0) {
            first = first.next;
        } else {
            int currentIndex = 0;
            Node node = first;
            while (currentIndex < index - 1) {
                node = node.next;
                currentIndex++;
            }

            node.next = node.next.next;
        }

        size--;
    }

    public void remove(Item item) {

        if (isEmpty()) {
            return;
        }

        if (item.equals(first.item)) {
            first = first.next;
        } else {
            Node pre = first;
            Node current = pre.next;

            while (current != null) {
                if (current.item.equals(item)) {
                    pre.next = current.next;
                    current = null;
                    break;
                } else {
                    pre = current;
                    current = current.next;
                }
            }
        }

        size--;
    }

    public boolean find(Item item) {
        if (isEmpty()) return false;

        Node current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void deleteLastNode() {
        Node current = first;
        Node next = current.next;

        while (next != null && next.next != null) {
            current = current.next;
            next = current.next;
        }

        current.next = null;
        next = null;

        size--;
    }

    public void removeAfter(Node node) {
        if (isEmpty()) return;

        Node current = first;
        while (current != null) {

            if (current.item.equals(node.item)) {
                Node next = current.next;
                if (next != null) {
                    current.next = next.next;
                }

                break;
            }

            current = current.next;
        }
    }

    public void insertAfter(Node target, Node insert) {
        if (isEmpty()) return;

        Node current = first;
        while (current != null) {
            if (current.item.equals(target.item)) {
                Node next = current.next;
                current.next = insert;
                insert.next = next;
            }
            current = current.next;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            Node next = current.next;
            current = next;
            return next.item;
        }
    }
}
