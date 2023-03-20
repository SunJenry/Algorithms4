package org.sun.chapter2.section2.exe;

import org.sun.chapter1.section3.Queue;

public class Exe14 {
    public static void main(String[] args) {
        //merge two sorted queue

    }

    public static Queue<Comparable> mergeTwoSortedQueue(Queue<Comparable> q1, Queue<Comparable> q2) {
        Queue<Comparable> objects = new Queue<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Comparable p1 = q1.peek();
            Comparable p2 = q2.peek();

            if (p1.compareTo(p2) < 0) {
                objects.enqueue(q1.pop());
            } else {
                objects.enqueue(q2.pop());
            }
        }

        while (!q1.isEmpty()) {
            objects.enqueue(q1.pop());
        }

        while (!q2.isEmpty()) {
            objects.enqueue(q2.pop());
        }

        return objects;
    }
}
