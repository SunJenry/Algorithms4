package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

public class Exercise22 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int key = 7;

        Arrays.sort(arr);

        rank(key, arr);
    }

    public static int rank(int key, int[] a) {
        int rank = rank(key, a, 0, a.length - 1);
        int rankWithIndex = rankWithIndex(key, a, 0, a.length - 1, 0);

        StdOut.printf("rank:" + rank + " rankWithIndex:" + rankWithIndex);

        return rank;
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (hi + lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int rankWithIndex(int key, int[] a, int lo, int hi, int depth) {
        if (lo > hi) return -1;
        int mid = (hi + lo) / 2;

        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }

        StdOut.print("lo: " + lo + " - hi: " + hi);
        StdOut.println();

        if (key < a[mid]) {
            return rankWithIndex(key, a, lo, mid - 1, ++depth);
        } else if (key > a[mid]) {
            return rankWithIndex(key, a, mid + 1, hi, ++depth);
        } else {
            return mid;
        }
    }
}
