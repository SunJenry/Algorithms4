package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Queue;
import org.sun.util.StdOut;
import org.sun.util.StdRandom;

public class Exercise37 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 7; i++) {
            queue.enqueue(i);
        }

        josephus(queue,2);
    }

    public static void josephus(Queue queue, int n) {
        while (!queue.isEmpty()) {
            for (int i = 0; i < n - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            Object dequeue = queue.dequeue();
            StdOut.println(dequeue);
        }
    }
}
