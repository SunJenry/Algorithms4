package org.sun.chapter2.section1.exe;

import org.sun.chapter2.AbsSort;
import org.sun.util.StdOut;

public class Exe11 {
    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 1, 3, 2};
        CalPreShellSort calPreShellSort = new CalPreShellSort();
        calPreShellSort.sort(ints);
        calPreShellSort.show(ints);
    }

    public static class CalPreShellSort extends AbsSort {

        @Override
        public void sort(Comparable[] a) {
            int N = a.length;

            int k = 1;
            int step = 1;

            while (k < N / 3) {
                k = 3 * k + 1;
                step++;
            }

            int[] stepArray = new int[step];

            for (int i = 0; i < step; i++) {
                stepArray[i] = k;
                k = (k - 1) / 3;
            }

            for (int i = 0; i < stepArray.length; i++) {
                int stepActual = stepArray[i];

                for (int j = stepActual; j < N; j++) {
                    for (int l = j; l >= stepActual && less(a[l], a[l - stepActual]); l -= stepActual) {
                        exch(a, l, l - stepActual);
                    }
                }
            }
        }
    }
}
