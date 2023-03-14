package org.sun.chapter2.section1;

import org.sun.chapter2.AbsSort;

public class SelectionSort extends AbsSort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            if (min != i) {
                exch(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(ints);
        selectionSort.show(ints);
    }
}
