package org.sun.chapter1.section4;

import org.sun.chapter1.section3.IQueue;
import org.sun.chapter1.section3.Stack;

import java.util.Iterator;

public class TwoStackQueue<Item> implements IQueue<Item> {

    protected final Stack<Item> inStack;
    protected final Stack<Item> outStack;

    public TwoStackQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    @Override
    public void enqueue(Item item) {
        inStack.push(item);
    }

    @Override
    public Item dequeue() {

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public int size() {
        return inStack.size() + outStack.size();
    }

    @Override
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException();
    }
}
