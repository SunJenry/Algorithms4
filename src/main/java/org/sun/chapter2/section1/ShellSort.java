package org.sun.chapter2.section1;

import org.sun.chapter2.AbsSort;

public class ShellSort extends AbsSort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(ints);
        shellSort.show(ints);
    }
}