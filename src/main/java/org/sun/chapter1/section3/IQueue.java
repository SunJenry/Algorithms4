package org.sun.chapter1.section3;

public interface IQueue<Item> extends Iterable<Item>  {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();

}
