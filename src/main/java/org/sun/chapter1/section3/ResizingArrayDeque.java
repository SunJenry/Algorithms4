package org.sun.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item> implements IDequeue<Item>, IResize {

    private static int DEFAULT_SIZE = 10;

    private Item[] array;
    private int headIndex;

    private int count;

    public ResizingArrayDeque() {
        array = (Item[]) new Object[DEFAULT_SIZE];
        headIndex = DEFAULT_SIZE / 2;
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
        array[headIndex] = item;
        headIndex--;
        count++;
        if (headIndex < 0) {
            if (size() > array.length / 2) {
                //enlarge array capacity
                resize(array.length * 2);
            } else {
                //shift data to array center
                resize(array.length);
            }
        }
    }

    @Override
    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = array[headIndex];
        array[headIndex] = null;
        headIndex++;
        count--;

        if (size() < array.length / 4) {
            resize(array.length / 2);
        }

        return item;
    }

    @Override
    public void pushRight(Item item) {
        int tailIndex = headIndex + size() + 1;
        array[tailIndex] = item;
        count++;

        if (tailIndex == array.length - 1) {
            if (size() > array.length / 2) {
                //enlarge array capacity
                resize(array.length * 2);
            } else {
                //shift data to array center
                resize(array.length);
            }
        }
    }

    @Override
    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException();

        int tailIndex = headIndex + size();

        Item item = array[tailIndex];
        array[tailIndex] = null;
        count--;

        if (size() < array.length / 4) {
            resize(array.length / 2);
        }

        return item;
    }

    @Override
    public void resize(int size) {
        Item[] temp = (Item[]) new Object[size];

        int startPos = (size - count) / 2;

        System.arraycopy(array, headIndex - 1, temp, startPos, count);

        headIndex = startPos - 1;

        array = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayDequeIterator(size());
    }

    private class ResizingArrayDequeIterator implements Iterator<Item> {

        private int current;
        private int count;

        public ResizingArrayDequeIterator(int count) {
            current = 0;
            this.count = count;
        }

        @Override
        public boolean hasNext() {
            return current < count;
        }

        @Override
        public Item next() {
            Item item = array[current];
            current++;
            return item;
        }
    }
}
