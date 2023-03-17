package org.sun.chapter2.section2.exe;

import org.sun.chapter2.AbsSort;
import org.sun.util.StdOut;
import org.sun.util.Stopwatch;
import org.sun.util.Util;

import java.util.Arrays;

public class Exe11 {
    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(20000000);
        Comparable[] comparables1 = Arrays.copyOf(comparables,comparables.length);

        Stopwatch stopwatch = new Stopwatch();
        ImprovedMergeSort improvedMergeSort = new ImprovedMergeSort();
        improvedMergeSort.sort(comparables);
        improvedMergeSort.isSorted(comparables);
        StdOut.println("TimeCost:" + stopwatch.elapsedTime());//typical 16.714s

        comparables = comparables1;
        stopwatch = new Stopwatch();
        ImprovedBUMergeSort improvedBUMergeSort = new ImprovedBUMergeSort();
        improvedBUMergeSort.sort(comparables);
        improvedBUMergeSort.isSorted(comparables);
        StdOut.println("TimeCost:" + stopwatch.elapsedTime());//typical 17.987s

        //seems for loop version is a little slower than recursive
    }

    public static class ImprovedMergeSort extends AbsSort {

        public static int CUTOFF = 15;

        @Override
        public void sort(Comparable[] a) {
            Comparable[] auxiliary = new Comparable[a.length];

            sort(a, 0, a.length - 1, auxiliary);
        }

        private void sort(Comparable[] a, int lo, int hi, Comparable[] auxiliary) {
            if (hi - lo <= CUTOFF) {
                //插入排序
                insertionSort(a, lo, hi);
                return;
            }

            int mid = (lo + hi) / 2;

            sort(a, lo, mid, auxiliary);
            sort(a, mid + 1, hi, auxiliary);

            if (a[mid + 1].compareTo(a[mid]) >= 0) {
                return;
            }

            merge(a, lo, mid, hi, auxiliary);
        }

        private void insertionSort(Comparable[] a, int lo, int hi) {
            for (int i = lo; i <= hi; i++) {
                for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                }
            }
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

    public static class ImprovedBUMergeSort extends AbsSort {

        private static int CUTOFF = 15;

        @Override
        public void sort(Comparable[] a) {
            Comparable[] auxiliary = new Comparable[a.length];
            int N = a.length;

            for (int sz = 1; sz < N; sz = 2 * sz) {
                for (int j = 0; j < N - sz; j += 2 * sz) {
                    int hi = Math.min(N - 1, j + 2 * sz - 1);
                    if (2 * sz <= CUTOFF) {
                        insertionSort(a, j, hi);
                    } else {
                        int mid = j + sz - 1;
                        merge(a, j, mid, hi, auxiliary);
                    }
                }
            }
        }

        private void insertionSort(Comparable[] a, int lo, int hi) {
            for (int i = lo + 1; i <= hi; i++) {
                for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                }
            }
        }

        private void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] auxiliary) {
            for (int i = lo; i <= hi; i++) {
                auxiliary[i] = a[i];
            }

            int i = lo;
            int j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = auxiliary[j++];
                else if (j > hi) {
                    a[k] = auxiliary[i++];
                } else if (less(auxiliary[i], auxiliary[j])) {
                    a[k] = auxiliary[i++];
                } else {
                    a[k] = auxiliary[j++];
                }
            }
        }
    }
}
