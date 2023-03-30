package org.sun.chapter2.section3.exe;

public class Exe16 {
    public static void main(String[] args) {
        /**
         * the reverse of quicksort
         */
    }

    public void bestCase(int[] array, int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;

        bestCase(array, lo, mid - 1);
        bestCase(array, mid + 1, hi);

        int temp = array[mid];
        array[mid] = array[lo];
        array[lo] = temp;
    }
}
