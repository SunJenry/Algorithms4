package org.sun.chapter2.section2.exe;

import org.sun.chapter1.section3.LinkedList;
import org.sun.util.StdOut;
import org.sun.util.StdRandom;

/**
 * confused again
 */
public class Exe18 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 100; i++) {
            linkedList.insert(i);
        }

        Exe18 exe18 = new Exe18();
        LinkedList.Node shuffleHead = exe18.shuffle(linkedList.getFirst());

        while (shuffleHead != null) {
            StdOut.print(shuffleHead.getItem() + ",");
            shuffleHead = shuffleHead.getNext();
        }
    }

    public LinkedList.Node shuffle(LinkedList.Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        LinkedList.Node firstHalf = head;
        LinkedList.Node mid = getMid(firstHalf);
        LinkedList.Node secondHalf = mid.getNext();

        return shuffleItem(shuffle(firstHalf), shuffle(secondHalf));
    }

    private LinkedList.Node shuffleItem(LinkedList.Node firstHalf, LinkedList.Node secondHalf) {
        LinkedList.Node dummyHead = new LinkedList().new Node();
        LinkedList.Node current = dummyHead;

        int[] size = getSize(firstHalf, secondHalf);
        int sizeFirstHalf = size[0];
        int sizeSecondHalf = size[1];

        double rate = sizeFirstHalf / (double) (sizeFirstHalf + sizeSecondHalf);

        while (firstHalf != null && secondHalf != null) {
            double uniformDouble = StdRandom.uniformDouble();

            if (uniformDouble < rate) {
                current.setNext(firstHalf);
                firstHalf = firstHalf.getNext();
                sizeFirstHalf--;
            } else {
                current.setNext(secondHalf);
                secondHalf = secondHalf.getNext();
                sizeSecondHalf--;
            }

            current = current.getNext();
        }

        current.setNext(firstHalf == null ? secondHalf : firstHalf);

        return dummyHead.getNext();
    }

    private int[] getSize(LinkedList.Node firstHalf, LinkedList.Node secondHalf) {
        int[] size = new int[2];

        int firstHalfSize = 0;
        int secondHalfSize = 0;

        while (firstHalf.getNext() != null && secondHalf.getNext() != null) {
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();

            firstHalfSize++;
            secondHalfSize++;
        }

        while (firstHalf.getNext() != null) {
            firstHalf = firstHalf.getNext();
            firstHalfSize++;
        }

        while (secondHalf.getNext() != null) {
            secondHalf = secondHalf.getNext();
            secondHalfSize++;
        }

        size[0] = firstHalfSize;
        size[1] = secondHalfSize;

        return size;
    }

    private LinkedList.Node getMid(LinkedList.Node head) {

        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
}
