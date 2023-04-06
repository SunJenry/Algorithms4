package org.sun.chapter2.section4.exe;

public class Exe24 {
    public static void main(String[] args) {

    }

    public static class BinaryTreeMaxPQ<Key extends Comparable<Key>> {
        public class Node {
            public Node parent;
            public Node childLeft;
            public Node childRight;

            public Key data;

            public Node() {
            }

            public Node(Key data) {
                this.data = data;
            }
        }

        public Node head;

        public BinaryTreeMaxPQ() {
            head = new Node();
        }

        public void insert(Key key) {
            Node node = new Node(key);

        }
    }
}
