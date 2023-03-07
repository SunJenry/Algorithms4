package org.sun.chapter1.section4;

public class SteQueue<Item> extends TwoStackQueue<Item> {
    public void push(Item item) {
        outStack.push(item);
    }

    public Item pop() {
        return dequeue();
    }
}
