package org.sun.chapter1.section3;

import org.sun.util.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements IQueue<Item>, IResize {

    private static final int DEFAULT_SIZE = 10;

    private Item[] items;
    private int count;

    public RandomQueue() {
        items = (Item[]) new Object[DEFAULT_SIZE];
        count = 0;
    }

    @Override
    public void enqueue(Item item) {
        items[count] = item;
        count++;

        if (count == items.length) {
            resize(items.length * 2);
        }
    }

    @Override
    public Item dequeue() {
        int i = StdRandom.uniformInt(0, size());
        Item item = items[i];
        items[i] = items[count - 1];
        items[count - 1] = null;
        count--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void resize(int size) {
        Item[] temp = (Item[]) new Object[size];
        System.arraycopy(items, 0, temp, 0, size());
        items = temp;
    }

    private class RandomQueueIterator implements Iterator<Item> {

        private Item[] randomItems;
        private int currentIndex;

        public RandomQueueIterator(Item[] items) {
            currentIndex = items.length - 1;

            randomItem(items);
        }

        private void randomItem(Item[] items) {
            Item[] temp = (Item[]) new Object[items.length];
            System.arraycopy(items, 0, temp, 0, items.length);

            for (int i = 0; i < items.length; i++) {
                int random = StdRandom.uniformInt(0, items.length);
                Item itemI = temp[i];
                temp[i] = temp[random];
                temp[random] = itemI;
            }
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public Item next() {
            Item item = items[currentIndex];
            currentIndex--;
            return item;
        }
    }
}
