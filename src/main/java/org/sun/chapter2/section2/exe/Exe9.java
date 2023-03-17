package org.sun.chapter2.section2.exe;

import org.sun.chapter2.AbsSort;

public class Exe9 {

    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ints);
        mergeSort.show(ints);
    }

    public static class MergeSort extends AbsSort {

        @Override
        public void sort(Comparable[] a) {
            Comparable[] auxiliary = new Comparable[a.length];

            sort(a, 0, a.length - 1, auxiliary);
        }

        private void sort(Comparable[] a, int lo, int hi, Comparable[] auxiliary) {
            if (lo >= hi) return;

            int mid = (lo + hi) / 2;

            sort(a, lo, mid, auxiliary);
            sort(a, mid + 1, hi, auxiliary);

            merge(a, lo, mid, hi, auxiliary);
        }

        private void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] auxiliary) {
            for (int i = lo; i <= hi; i++) {
                auxiliary[i] = a[i];
            }

            int i = lo;
            int j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = auxiliary[j++];
                else if (j > hi) a[k] = auxiliary[i++];
                else if (less(auxiliary[i], auxiliary[j])) a[k] = auxiliary[i++];
                else a[k] = auxiliary[j++];
            }
        }
    }
}
