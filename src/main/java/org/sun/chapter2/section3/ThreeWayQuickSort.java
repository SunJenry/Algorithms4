package org.sun.chapter2.section3;

import org.sun.chapter2.AbsSort;
import org.sun.util.StdRandom;
import org.sun.util.Util;

public class ThreeWayQuickSort extends AbsSort {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        threeWayQuickSort(a, 0, a.length - 1);
    }

    private void threeWayQuickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int[] partition = partition(a, lo, hi);

        int lt = partition[0];
        int gt = partition[1];

        threeWayQuickSort(a, lo, lt - 1);
        threeWayQuickSort(a, gt + 1, hi);
    }

    private int[] partition(Comparable[] a, int lo, int hi) {
        int[] pos = new int[2];

        Comparable partitionEle = a[lo];

        int lt = lo, leftStart = lo + 1, gt = hi;

        while (leftStart <= gt) {
            int cmp = a[leftStart].compareTo(partitionEle);

            if (cmp == 0) {
                leftStart++;
            } else if (cmp < 0) {
                exch(a, leftStart++, lt++);
            } else {
                exch(a, leftStart, gt--);
            }
        }

        pos[0] = lt;
        pos[1] = gt;

        return pos;
    }

    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(200);
        ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();
        threeWayQuickSort.sort(comparables);
        threeWayQuickSort.isSorted(comparables);
    }
}
