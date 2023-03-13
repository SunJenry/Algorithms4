package org.sun.chapter2.section1;

import org.sun.chapter2.AbsSort;

public class InsertionSort extends AbsSort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {9,8,6,5,7,4,2,3,1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(ints);
        insertionSort.show(ints);
    }
}
