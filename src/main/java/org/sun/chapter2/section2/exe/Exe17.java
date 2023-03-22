package org.sun.chapter2.section2.exe;

import org.sun.chapter1.section3.LinkedList;
import org.sun.util.StdOut;

/**
 * just confused...
 */
public class Exe17 {

    private static class NodePair {
        LinkedList<Integer>.Node node1;
        LinkedList<Integer>.Node node2;

        public NodePair(LinkedList<Integer>.Node node1, LinkedList<Integer>.Node node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        int count = 50;
        for (int i = 0; i < count; i++) {
            integers.insert(count-i);
        }

        StdOut.println();

        LinkedList.Node node = sortLinkedList(integers.getFirst());

        Comparable comparable = node.getItem();
        while (node.getNext() != null) {
            Comparable comparable1 = node.getNext().getItem();
            if (comparable1.compareTo(comparable) < 0) {
                StdOut.println("Not Sorted!!");
                return;
            }
            comparable = comparable1;
            node = node.getNext();
        }

        StdOut.println("Sorted!!");
    }

    public static LinkedList.Node sortLinkedList(LinkedList<Integer>.Node node) {

        LinkedList.Node headNode = node;
        LinkedList.Node sortedMark = node;

        while (sortedMark.getNext() != null) {
            LinkedList.Node lo = sortedMark;

            StdOut.println("mid:" + lo.getItem());
            StdOut.println("mid Next:" + sortedMark.getNext().getItem());
            LinkedList.Node hi = findNextSortedNode(sortedMark.getNext());
            StdOut.println("hi :" + hi.getItem());

            NodePair nodePair = mergeSortedNode(headNode, lo, hi, hi.getNext());

            headNode = nodePair.node1;
            sortedMark = nodePair.node2;

            LinkedList.Node head = headNode;

            printNode(head);
            StdOut.println("marked:" + sortedMark.getItem());
        }

        return headNode;
    }

    private static void printNode(LinkedList.Node head) {
        while (head != null) {
            StdOut.print(head.getItem() + ",");
            head = head.getNext();
        }
        StdOut.println();
    }

    private static NodePair mergeSortedNode(LinkedList.Node lo, LinkedList.Node mid, LinkedList.Node hi, LinkedList.Node hiNext) {
        LinkedList.Node headNode = lo;
        LinkedList.Node firstNode = lo;
        LinkedList.Node secondPre = mid;
        LinkedList.Node secondNode = mid.getNext();
        LinkedList.Node currentSortNode = null;

        //确保不越界
        while (true) {
            StdOut.println("first:" + firstNode.getItem() + " second:" + secondNode.getItem());
            if (firstNode.getItem().compareTo(secondNode.getItem()) < 0) {
                currentSortNode = firstNode;
                firstNode = firstNode.getNext();
            } else {
                LinkedList.Node next = secondNode.getNext();
//                StdOut.println("Second Next:" + next.getItem());

                secondPre.setNext(next);

                if (currentSortNode == null) {
                    //首次排序需要改变头部
                    secondNode.setNext(headNode);
                    headNode = secondNode;
                } else {
                    LinkedList.Node nextCurrent = currentSortNode.getNext();
                    secondNode.setNext(nextCurrent);
                    currentSortNode.setNext(secondNode);
                }

                currentSortNode = secondNode;
                secondNode = next;
            }

            StdOut.println("Inner:");
            printNode(headNode);

            if (firstNode == mid.getNext() || secondNode == hiNext) {
                break;
            }
        }

        if (firstNode != mid.getNext()) {
            currentSortNode = mid;
        }

        if (secondNode != hi.getNext()) {
            currentSortNode = hi;
        }

        return new NodePair(headNode, currentSortNode);
    }

    private static LinkedList<Integer>.Node findNextSortedNode(LinkedList<Integer>.Node startNode) {
        LinkedList.Node sortedNode = startNode;
        while (sortedNode.getNext() != null) {
            if (sortedNode.getNext().getItem().compareTo(sortedNode.getItem()) < 0) {
                return sortedNode;
            }
            sortedNode = sortedNode.getNext();
        }

        return sortedNode;
    }
}
