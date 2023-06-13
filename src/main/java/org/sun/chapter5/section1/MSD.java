package org.sun.chapter5.section1;

import org.sun.chapter2.section1.InsertionSort;

public class MSD {

    private static int R = 256;//radix
    private static final int M = 15;//cutoff for small subarray
    private static String[] aux;//auxiliary array for distribution

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
//            Insertion.sort(a, lo, hi, d); return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int i = 0; i < R + 1; i++) {
            count[i + 1] = count[i];
        }

        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        for (int i = 0; i < R; i++) {
            sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
        }
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        return -1;
    }
}
