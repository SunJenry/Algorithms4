package org.sun.chapter2.section4;

import org.sun.chapter2.section4.exe.Exe15;
import org.sun.util.StdOut;
import org.sun.util.Util;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    /**
     * create a priority queue
     */
    public MaxPQ() {
    }

    /**
     * create a priority queue of initial capacity max
     *
     * @param max
     */
    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];

    }

    /**
     * create  a priority queue from the keys in a[]
     *
     * @param a
     */
    public MaxPQ(Key[] a) {
        N = a.length;
        Comparable[] objects = new Comparable[a.length + 1];
        objects[0] = null;
        for (int i = 0; i < a.length; i++) {
            objects[i + 1] = a[i];
        }
        pq = (Key[]) objects;
        sort();
    }

    /**
     * insert a key into the priority queue
     *
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * return the largest key
     *
     * @return
     */
    public Key max() {
        return null;
    }

    /**
     * return and remove the largest key
     *
     * @return
     */
    public Key delMax() {
        Key max = pq[1];

        exch(1, N);

        pq[N] = null;

        N--;

        sink(1);

        return max;
    }

    /**
     * is the priority queue empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * number of keys in the priority queue
     *
     * @return
     */
    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void sort() {
        for (int i = N / 2; i > 0; i--) {
            sink(i);
        }
    }

    public void printPQ() {
        StdOut.println(Arrays.toString(pq));
    }

    public boolean isMaxHeapSorted() {
        boolean b = Exe15.maxHeapArrayVerify(pq);
        StdOut.println("MaxHeapSorted:" + b);
        return b;
    }
}
