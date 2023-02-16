package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.IQueue;
import org.sun.chapter1.section3.Stack;

import java.util.Iterator;

public class Exercise49 {
    public static void main(String[] args) {

    }

    public static class ThreeStackQueue<Item> implements IQueue<Item> {

        private Stack<Item> leftStack;
        private Stack<Item> middleStack;
        private Stack<Item> rightStack;

        private int size;

        public ThreeStackQueue() {
            leftStack = new Stack<>();
            middleStack = new Stack<>();
            rightStack = new Stack<>();

            size = 0;
        }


        @Override
        public void enqueue(Item item) {
            leftStack.push(item);
            size++;
        }

        @Override
        public Item dequeue() {
            if (isEmpty()) return null;

            Item item;
            if (rightStack.isEmpty()) {
                while (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            }

            item = rightStack.pop();

            size--;

            return item;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Iterator<Item> iterator() {
            return null;
        }
    }
}