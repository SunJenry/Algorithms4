package org.sun.chapter1.section3;

import java.util.HashSet;
import java.util.Set;

public class MoveToFront<Item> {
    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private Node<Item> head;
    private int size;

    private Set<Item> itemSet;

    public MoveToFront() {
        size = 0;
        itemSet = new HashSet<>();
    }

    public void insert(Item item) {
        if (itemSet.contains(item)) {
            Node<Item> node = head;
            Node<Item> previous = null;
            while (node != null) {
                if (node.item.equals(item)) {
                    break;
                }
                previous = node;
                node = node.next;
            }

            if (node == null){
                throw new IllegalStateException();
            }

            if (previous != null) {
                previous.next = node.next;
                node.next = head;
                head = node;
            } else {
                //already first, do nothing
            }
        } else {
            Node<Item> itemNode = new Node<>();
            itemNode.item = item;
            itemNode.next = head;
            head = itemNode;
        }
    }
}
