package org.sun.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements IQueue<Item> {

    private static class Node<Item> {
        private Node<Item> next;
        private Item item;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int count;

    public Queue() {
        first = null;
        last = null;
        count = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }

    @Override
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

        count++;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        count--;
        return item;
    }

    public Item pop() {
        return dequeue();
    }

    public void push(Item item) {
        Node<Item> itemNode = new Node<>();
        itemNode.item = item;
        if (isEmpty()) {
            first = last = itemNode;
        } else {
            itemNode.next = first;
            first = itemNode;
        }

        count++;
    }

    public Queue<Item> copy() {
        Queue<Item> items = new Queue<>();
        for (Item item : this) {
            items.enqueue(item);
        }

        return items;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;

        public LinkedIterator(Node<Item> node) {
            current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
