package org.sun.chapter3.section4.exe;

import org.sun.chapter1.section3.Queue;

import java.util.ArrayList;
import java.util.List;

public class Exe2 {

    private class SeparateChainingHashTableLinkedList<Key, Value> {

        private class Node {
            Key key;
            Value value;
            Node next;

            public Node(Key key, Value value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        private List<Node> buckets;
        private int keysSize;
        private int numberOfBuckets;

        private int averageListSize;

        private static final int DEFAULT_NUMBER_OF_BUCKETS = 50;
        private static final int DEFAULT_AVERAGE_LIST_SIZE = 5;

        // The largest prime <= 2^i for i = 1 to 31
        // Used to distribute keys uniformly in the hash table after resizes
        // PRIMES[n] = 2^k - Ak where k is the power of 2 and Ak is the value to subtract to reach the previous prime number
        private final int[] PRIMES = {
                1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
                32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
                8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
                536870909, 1073741789, 2147483647
        };

        // The lg of the hash table size
        // Used in combination with PRIMES[] to distribute keys uniformly in the hash function after resizes
        private int lgM;

        public SeparateChainingHashTableLinkedList() {
            this(DEFAULT_NUMBER_OF_BUCKETS, DEFAULT_AVERAGE_LIST_SIZE);
        }

        SeparateChainingHashTableLinkedList(int numberOfBuckets, int averageListSize) {
            keysSize = 0;
            this.numberOfBuckets = numberOfBuckets;
            buckets = new ArrayList<>(numberOfBuckets);

            this.averageListSize = averageListSize;

            for (int i = 0; i < numberOfBuckets; i++) {
                buckets.add(null);
            }
            lgM = (int) (Math.log(numberOfBuckets) / Math.log(2));
        }

        private int hash(Key key) {
            int hash = key.hashCode() & 0x7fffffff;

            if (lgM < 26) {
                hash = hash % PRIMES[lgM + 5];
            }
            return hash % numberOfBuckets;
        }

        private double getLoadFactor() {
            return ((double) keysSize) / (double) numberOfBuckets;
        }

        public boolean isEmpty() {
            return keysSize == 0;
        }

        public int size() {
            return keysSize;
        }

        public boolean contains(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Argument to contains() cannot be null");
            }
            return get(key) != null;
        }

        private void resize(int newBucketSize) {
            List<Node> tempBuckets = buckets;
            buckets = new ArrayList<>(newBucketSize);

            numberOfBuckets = newBucketSize;
            keysSize = 0;

            for (int i = 0; i < newBucketSize; i++) {
                buckets.add(null);
            }

            for (Node node : tempBuckets) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }

        public Value get(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Argument to get() cannot be null");
            }

            // Get node at the head of the bucket
            Node node = buckets.get(hash(key));

            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

        public void put(Key key, Value value) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            if (value == null) {
                delete(key);
                return;
            }

            // Get node at the head of the bucket
            int bucketIndex = hash(key);
            Node node = buckets.get(bucketIndex);

            // Update key value if it already exists
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }

            keysSize++;
            node = buckets.get(bucketIndex);
            Node newNode = new Node(key, value, node);
            buckets.set(bucketIndex, newNode);

            if (getLoadFactor() > averageListSize) {
                resize(numberOfBuckets * 2);
                lgM++;
            }
        }

        public void delete(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Argument to delete() cannot be null");
            }

            if (isEmpty() || !contains(key)) {
                return;
            }

            int bucketIndex = hash(key);
            Node node = buckets.get(bucketIndex);

            keysSize--;

            if (node.key.equals(key)) {
                buckets.set(bucketIndex, node.next);
            } else {
                while (node != null) {
                    if (node.next.key.equals(key)) {
                        node.next = node.next.next;
                        break;
                    }

                    node = node.next;
                }
            }

            if (numberOfBuckets > 1 && getLoadFactor() <= averageListSize / (double) 4) {
                resize(numberOfBuckets / 2);
                lgM--;
            }
        }

        public Iterable<Key> keys() {
            Queue<Key> keys = new Queue<>();

            for (int i = 0; i < buckets.size(); i++) {
                if (buckets.get(i) != null) {
                    Node node = buckets.get(i);

                    while (node != null) {
                        keys.enqueue(node.key);
                        node = node.next;
                    }
                }
            }
            return keys;
        }
    }
    public static void main(String[] args) {

    }
}
