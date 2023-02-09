package org.sun.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedDeque<Item> implements IDequeue<Item> {

    private class Node {
        Item item;
        Node next;
        Node pre;
    }

    private Node head;
    private Node tail;
    private int count;

    public DoubleLinkedDeque() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }

        count++;
    }

    @Override
    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = head.item;

        count--;

        if (isEmpty()) {
            head = tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }

        return item;
    }

    @Override
    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }

        count++;
    }

    @Override
    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = tail.item;

        count--;

        if (isEmpty()) {
            head = tail = null;
        } else {
            Node pre = tail.pre;
            pre.next = null;
            tail = pre;
        }

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoubleLinkedDequeIterator(head, tail);
    }

    private class DoubleLinkedDequeIterator implements Iterator<Item> {

        private Node head;
        private Node tail;
        private Node current;

        public DoubleLinkedDequeIterator(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
            current = this.head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}
