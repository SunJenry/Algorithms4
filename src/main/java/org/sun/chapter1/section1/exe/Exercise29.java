package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

public class Exercise29 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8};
        int key = 5;

        int rank = rank(array, key);

        int count = count(array, key);

        StdOut.println("rank:" + rank + " count:" + count);
    }

    public static int rank(int[] array, int key) {
        return lessThanKey(array, key, 0, array.length - 1);
    }

    public static int lessThanKey(int[] array, int key, int lo, int hi) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (key > array[mid]) {
                return lessThanKey(array, key, mid + 1, hi);
            } else {
                return lessThanKey(array, key, lo, mid - 1);
            }
        }

        return lo;
    }

    public static int greaterThanKey(int[] array, int key, int lo, int hi) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (key < array[mid]) {
                return greaterThanKey(array, key, lo, mid - 1);
            } else {
                return greaterThanKey(array, key, mid + 1, hi);
            }
        }

        return array.length - 1 - hi;
    }

    public static int count(int[] array, int key) {
        int lessThanKey = lessThanKey(array, key, 0, array.length - 1);
        StdOut.println("lessThanKey:" + lessThanKey);
        int greaterThanKey = greaterThanKey(array, key, 0, array.length - 1);
        StdOut.println("greaterThanKey:" + greaterThanKey);

        return array.length - lessThanKey - greaterThanKey;
    }
}
