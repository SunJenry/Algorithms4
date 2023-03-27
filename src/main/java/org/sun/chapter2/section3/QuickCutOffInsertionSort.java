package org.sun.chapter2.section3;

import org.sun.chapter2.AbsSort;
import org.sun.util.StdRandom;
import org.sun.util.Util;

public class QuickCutOffInsertionSort extends AbsSort {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);

        quickInsertionSort(a, 0, a.length - 1);
    }

    private void quickInsertionSort(Comparable[] a, int lo, int hi) {
        if (hi - lo <= 16) {
            insertionSort(a, lo, hi);
            return;
        }

        int j = partition(a, lo, hi);

        quickInsertionSort(a, lo, j - 1);
        quickInsertionSort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        Comparable partitionElement = a[lo];

        while (i < j) {
            while (less(a[++i], partitionElement)) {
                if (i >= hi) break;
            }

            while (less(partitionElement, a[--j])) {
                if (j <= lo) break;
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;
    }

    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(2000);
        QuickCutOffInsertionSort quickInsertionSort = new QuickCutOffInsertionSort();
        quickInsertionSort.sort(comparables);
        quickInsertionSort.isSorted(comparables);
    }
}
