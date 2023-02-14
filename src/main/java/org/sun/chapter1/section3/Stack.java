package org.sun.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first;
    private int count;

    public Stack() {
        first = null;
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

    public void push(Item item) {
        Node<Item> itemNode = new Node<>();
        itemNode.item = item;
        itemNode.next = first;
        first = itemNode;
        count++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;
        count--;

        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();

        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public Stack<Item> copy() {
        Stack<Item> items = new Stack<>();
        Stack<Item> temp = new Stack<>();

        for (Item item : this) {
            temp.push(item);
        }

        for (Item item : temp) {
            items.push(item);
        }

        return items;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;

        public LinkedIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();

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
