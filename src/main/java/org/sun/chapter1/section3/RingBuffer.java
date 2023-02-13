package org.sun.chapter1.section3;

public class RingBuffer<Item> implements IRingBuffer<Item> {

    private Item[] buffer;
    private int head;
    private int tail;
    private int size;

    private Queue<Item> auxQueue;

    public RingBuffer(int capacity) {
        buffer = (Item[]) new Object[capacity];
        size = 0;
        head = tail = -1;

        auxQueue = new Queue<>();
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
    public void write(Item item) {
        if (isEmpty()) {
            buffer[0] = item;
            head = 0;
            tail = 0;
            size++;
        } else {
            if (size < buffer.length) {
                if (tail == buffer.length - 1) {
                    tail = 0;
                } else {
                    tail++;
                }

                buffer[tail] = item;
                size++;
            } else {
                auxQueue.enqueue(item);
            }
        }
    }

    @Override
    public Item read() {

        Item item = buffer[head];
        buffer[head] = null;
        size--;

        if (head == buffer.length - 1) {
            head = 0;
        } else {
            head++;
        }

        if (!auxQueue.isEmpty()) {
            write(auxQueue.pop());
        }

        return item;
    }
}
