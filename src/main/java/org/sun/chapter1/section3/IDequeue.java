package org.sun.chapter1.section3;

public interface IDequeue<Item> extends Iterable<Item> {
    boolean isEmpty();

    int size();

    void pushLeft(Item item);

    Item popLeft();

    void pushRight(Item item);

    Item popRight();
}
