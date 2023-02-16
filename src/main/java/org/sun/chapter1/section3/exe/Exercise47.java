package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.LinkedListCircular;
import org.sun.chapter1.section3.Queue;

public class Exercise47<Item> {
    public static void main(String[] args) {

    }

    public LinkedListCircular<Item> catenationQueues(Queue<Item> queue1, Queue<Item> queue2) {
        if (queue1 == null || queue2 == null) {
            return null;
        }
        LinkedListCircular<Item> linkedListCircular = new LinkedListCircular<>();

        while (!queue1.isEmpty()) {
            Item item = queue1.dequeue();
            linkedListCircular.insert(item);
        }

        while (!queue2.isEmpty()) {
            Item item = queue2.dequeue();
            linkedListCircular.insert(item);
        }
        return linkedListCircular;
    }
}
