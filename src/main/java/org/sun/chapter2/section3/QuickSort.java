package org.sun.chapter2.section3;

import org.sun.chapter2.AbsSort;
import org.sun.util.StdRandom;
import org.sun.util.Util;

public class QuickSort extends AbsSort {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable partition = a[lo];

        while (true) {
            while (less(a[++i], partition)) {
                if (i == hi) break;
            }

            while (less(partition, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) break;

            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;
    }

    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(20);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(comparables);
        quickSort.isSorted(comparables);
    }
}
