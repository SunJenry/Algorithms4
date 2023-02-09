package org.sun.chapter1.section3;

import org.sun.util.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements IBag<Item>, IResize {

    private static final int DEFAULT_SIZE = 10;

    private Item[] items;
    private int size;

    public RandomBag() {
        items = (Item[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(Item item) {
        items[size] = item;
        size++;
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void resize(int size) {
        Item[] temp = (Item[]) new Object[size];

        System.arraycopy(items, 0, temp, 0, size());

        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class RandomBagIterator implements Iterator<Item> {

        private Item[] randomItems;
        private int currentIndex;

        public RandomBagIterator(Item[] items) {
            currentIndex = 0;

            randomItem(items);
        }

        private void randomItem(Item[] items) {
            Item[] temp = (Item[]) new Object[items.length];
            System.arraycopy(items, 0, temp, 0, items.length);

            //random swap
            for (int i = 0; i < items.length; i++) {
                int uniformInt = StdRandom.uniformInt(0, items.length);
                Item itemI = temp[i];
                temp[i] = temp[uniformInt];
                temp[uniformInt] = itemI;
            }

            randomItems = temp;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < randomItems.length;
        }

        @Override
        public Item next() {
            Item randomItem = randomItems[currentIndex];
            currentIndex++;
            return randomItem;
        }
    }
}
