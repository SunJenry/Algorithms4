package org.sun.chapter2.section2.exe;

import org.sun.chapter2.AbsSort;
import org.sun.util.Util;

public class Exe10 {
    public static void main(String[] args) {
        Comparable[] ints = Util.generateRandomArray(20);
        FastMerge fastMerge = new FastMerge();
        fastMerge.sort(ints);
        fastMerge.isSorted(ints);
        fastMerge.show(ints);
    }

    public static class FastMerge extends AbsSort {

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

            for (int i = lo; i <= mid; i++) {
                auxiliary[i] = a[i];
            }

            for (int i = hi; i > mid; i--) {
                auxiliary[mid + 1 + hi - i] = a[i];
            }

            int headStart = lo;
            int endStart = hi;
            int start = lo;

            while (headStart <= endStart) {
                if (less(auxiliary[headStart], auxiliary[endStart])) {
                    a[start++] = auxiliary[headStart++];
                } else {
                    a[start++] = auxiliary[endStart--];
                }
            }
        }
    }
}
