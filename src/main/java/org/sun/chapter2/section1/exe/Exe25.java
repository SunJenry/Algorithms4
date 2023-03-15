package org.sun.chapter2.section1.exe;

import org.sun.chapter2.AbsSort;

public class Exe25 {
    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        NoSwapInsertionSort noSwapInsertionSort = new NoSwapInsertionSort();
        noSwapInsertionSort.sort(ints);
        noSwapInsertionSort.show(ints);
    }

    public static class NoSwapInsertionSort extends AbsSort {

        @Override
        public void sort(Comparable[] a) {
            int length = a.length;

            int h = 1;
            while (h < length / 3) h = 3 * h + 1;

            while (h >= 1) {
                for (int i = h; i < length; i++) {
                    Comparable aux = a[i];
                    int j = i;
                    for (; j > 0 && less(aux, a[j - 1]); j--) {
                        a[j] = a[j - 1];
                    }

                    a[j] = aux;
                }

                h = h / 3;
            }
        }
    }
}
