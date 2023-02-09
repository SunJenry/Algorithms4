package org.sun.chapter1.section3;

public interface IBag<Item> extends Iterable<Item> {
    void add(Item item);

    boolean isEmpty();

    int size();
}
