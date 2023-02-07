package org.sun.chapter1.section3.exe;

import java.util.NoSuchElementException;

public class Exercise14 {
    public static void main(String[] args) {

    }

    public static class ResizingArrayQueue<T> {
        private T[] items;
        private int n;
        private int first;
        private int last;

        public boolean isEmpty() {
            return n == 0;
        }

        public ResizingArrayQueue(int n) {
            this.items = (T[]) new Object[n];
            this.n = n;
            first = last = 0;
        }

        private void resize(int capacity) {
            T[] objects = (T[]) new Object[capacity];
            int index = 0;
            for (int i = first; i < last; i++) {
                objects[index] = items[i];
            }

            items = objects;
            first = 0;
            last = n;
        }

        public int size() {
            return n;
        }

        public void enqueue(T t) {
            if (n == items.length) resize(2 * n);

            if (last == items.length) {
                last = 0;
            }

            items[last++] = t;
            n++;
        }

        public T dequeue() {
            if (isEmpty()) throw new NoSuchElementException();

            T item = items[first];

            items[first] = null;
            first++;
            n--;

            if (first == items.length) first = 0;

            if (n > 0 && n < items.length / 4) {
                resize(items.length / 2);
            }

            return item;
        }
    }
}
