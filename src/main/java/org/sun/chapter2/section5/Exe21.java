package org.sun.chapter2.section5;

import java.util.Comparator;

public class Exe21 {
    private static class VectorSort implements Comparator<int[]> {
        public int dimension;

        public VectorSort(int dimension) {
            this.dimension = dimension;
        }

        public int compare(int[] a, int[] b) {
            if (a[dimension] > b[dimension]) {
                return 1;
            } else if (a[dimension] < b[dimension]) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
