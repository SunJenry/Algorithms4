package org.sun.chapter2.section1.exe;

import org.sun.chapter2.AbsSort;

public class Exe24 {
    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        SentinelInsertionSort sentinelInsertionSort = new SentinelInsertionSort();
        sentinelInsertionSort.sort(ints);
        sentinelInsertionSort.show(ints);
    }

    public static class SentinelInsertionSort extends AbsSort {

        @Override
        public void sort(Comparable[] a) {
            int length = a.length;

            int minIndex = 0;
            Comparable minValue = a[0];
            for (int i = 1; i < length; i++) {
                if (a[i].compareTo(minValue) < 0) {
                    minValue = a[i];
                    minIndex = i;
                }
            }

            exch(a, 0, minIndex);

            for (int i = 1; i < length; i++) {
                for (int j = i; less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                }
            }
        }
    }
}
