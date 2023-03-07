package org.sun.chapter1.section3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements IStack<Item>,Iterable<Item> {

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

    @Override
    public void push(Item item) {
        Node<Item> itemNode = new Node<>();
        itemNode.item = item;
        itemNode.next = first;
        first = itemNode;
        count++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;
        count--;

        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();

        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
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
        return new LinkedIterator(first, count);
    }

    public class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;
        private int currentCount;

        public LinkedIterator(Node<Item> current, int count) {
            this.current = current;
            this.currentCount = count;
        }

        @Override
        public boolean hasNext() {
            if (count != currentCount) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public Item next() {

            if (count != currentCount) {
                throw new ConcurrentModificationException();
            }

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
