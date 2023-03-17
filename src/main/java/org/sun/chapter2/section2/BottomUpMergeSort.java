package org.sun.chapter2.section2;

import org.sun.util.Util;

public class BottomUpMergeSort extends MergeSort {
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int length = a.length;

        for (int sz = 1; sz < length; sz *= 2) {
            for (int i = 0; i < length - sz; i += sz * 2) {
                int hi = Math.min(length - 1, i + 2 * sz - 1);
                int mid = i + sz - 1;
                merge(a, i, mid, hi);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(2000);
        BottomUpMergeSort bottomUpMergeSort = new BottomUpMergeSort();
        bottomUpMergeSort.sort(comparables);
        bottomUpMergeSort.isSorted(comparables);
        bottomUpMergeSort.show(comparables);
    }
}
