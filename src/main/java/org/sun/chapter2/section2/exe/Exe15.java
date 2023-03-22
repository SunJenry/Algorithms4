package org.sun.chapter2.section2.exe;

import org.sun.chapter1.section3.Queue;

public class Exe15 {
    public static void main(String[] args) {

    }

    private static Queue<Queue<Comparable>> bottomUpQueueMergesort(Comparable[] array) {
        Queue<Queue<Comparable>> sortedQueues = new Queue<>();

        for (Comparable value : array) {
            Queue<Comparable> queue = new Queue<>();
            queue.enqueue(value);

            sortedQueues.enqueue(queue);
        }

        while (sortedQueues.size() > 1) {
            Queue<Comparable> queue1 = sortedQueues.dequeue();
            Queue<Comparable> queue2 = sortedQueues.dequeue();

            Queue<Comparable> mergedQueue = Exe14.mergeTwoSortedQueue(queue1, queue2);
            sortedQueues.enqueue(mergedQueue);
        }
        return sortedQueues;
    }
}
