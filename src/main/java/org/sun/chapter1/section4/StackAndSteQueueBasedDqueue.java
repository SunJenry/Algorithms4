package org.sun.chapter1.section4;

import org.sun.chapter1.section3.IDequeue;
import org.sun.chapter1.section3.Stack;

import java.util.Iterator;

public class StackAndSteQueueBasedDqueue<Item> implements IDequeue<Item> {

    private final Stack<Item> itemStack;
    private final SteQueue<Item> itemsSteQueue;

    public StackAndSteQueueBasedDqueue() {
        itemStack = new Stack<>();
        itemsSteQueue = new SteQueue<>();
    }

    @Override
    public boolean isEmpty() {
        return itemStack.isEmpty() && itemsSteQueue.isEmpty();
    }

    @Override
    public int size() {
        return itemStack.size() + itemsSteQueue.size();
    }

    @Override
    public void pushLeft(Item item) {
        itemStack.push(item);
    }

    @Override
    public Item popLeft() {
        if (itemStack.isEmpty()){
            //only move half to keep head in stequeue
            moveHalfToStack();
        }

        return itemStack.pop();
    }

    private void moveHalfToStack() {
        int halfSize = itemsSteQueue.size()/2;
        int remainSize = itemsSteQueue.size() - halfSize;

        for (int i = 0; i < halfSize; i++) {
            itemsSteQueue.enqueue(itemsSteQueue.pop());
        }

        for (int i = 0; i < remainSize; i++) {
            itemStack.push(itemsSteQueue.pop());
        }
    }

    @Override
    public void pushRight(Item item) {
        itemsSteQueue.push(item);
    }

    @Override
    public Item popRight() {
        if (itemsSteQueue.isEmpty()) {
            while (!itemStack.isEmpty()) {
                itemsSteQueue.push(itemStack.pop());
            }
        }
        return itemsSteQueue.pop();
    }

    @Override
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException();
    }
}
