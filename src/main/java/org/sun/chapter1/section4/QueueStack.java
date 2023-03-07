package org.sun.chapter1.section4;

import org.sun.chapter1.section3.IStack;
import org.sun.chapter1.section3.Queue;

public class QueueStack<Item> implements IStack<Item> {

    private final Queue<Item> queue;

    public QueueStack() {
        queue = new Queue<>();
    }

    @Override
    public void push(Item item) {
        queue.enqueue(item);
    }

    @Override
    public Item pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            Item pop = queue.pop();
            queue.enqueue(pop);
        }

        return queue.pop();
    }

    @Override
    public Item peek() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            Item pop = queue.pop();
            queue.enqueue(pop);
        }

        Item pop = queue.pop();
        queue.enqueue(pop);
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
