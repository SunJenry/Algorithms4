package org.sun.chapter1.section3;

public interface IRingBuffer<Item> {
    boolean isEmpty();

    int size();

    void write(Item item);

    Item read();
}
