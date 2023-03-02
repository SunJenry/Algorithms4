package org.sun.chapter1.section2;

import java.util.Arrays;

public class StaticSEofInts {
    private int[] a;

    public StaticSEofInts(int[] array) {
        a = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }

        Arrays.sort(a);
    }

    public boolean contains(int a) {
        return rank(a) != -1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = a.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int howMany(int key) {
        if (!contains(key)) return 0;

        return rankLargest(key) - rankSmallest(key) + 1;
    }

    public int rankSmallest(int key) {
        int lo = 0;
        int hi = a.length;

        int smallestIndex = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                smallestIndex = mid;
                hi = mid - 1;
            }
        }

        return smallestIndex;
    }

    public int rankLargest(int key) {
        int lo = 0;
        int hi = a.length;

        int largestIndex = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                largestIndex = mid;
                lo = mid + 1;
            }
        }

        return largestIndex;
    }
}
