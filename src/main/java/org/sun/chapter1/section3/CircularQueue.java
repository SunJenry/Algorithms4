package org.sun.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<Item> implements Iterable<Item> {

    private static class Node<Item> {
        Node<Item> next;
        Item item;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int count;

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }

    public void enqueue(Item item) {
        Node<Item> itemNode = new Node<>();
        itemNode.item = item;
        itemNode.next = null;
        if (isEmpty()) {
            first = last = itemNode;
        } else {
            last.next = itemNode;
            last = itemNode;
        }

        last.next = first;

        count++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        } else {
            last.next = first;
        }
        count--;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }


    @Override
    public Iterator<Item> iterator() {
        return new CircularQueueIterator(first, last);
    }

    private class CircularQueueIterator implements Iterator<Item> {

        private Node<Item> first;
        private Node<Item> last;

        private Node<Item> current;

        public CircularQueueIterator(Node<Item> first, Node<Item> last) {
            this.first = first;
            this.last = last;
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null && current != last;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
