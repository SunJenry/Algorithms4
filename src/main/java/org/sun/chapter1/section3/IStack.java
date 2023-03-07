package org.sun.chapter1.section3;

public interface IStack<Item> {
    void push(Item item);

    Item pop();

    Item peek();

    boolean isEmpty();

    int size();
}
