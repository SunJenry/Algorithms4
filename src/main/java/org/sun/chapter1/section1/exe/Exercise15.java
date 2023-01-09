package org.sun.chapter1.section1.exe;

import java.util.Arrays;

public class Exercise15 {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
        int m = 8;
        int[] histogramA = histogram(a, m);

        System.out.println("a:" + Arrays.toString(a) + " histogramA:" + Arrays.toString(histogramA));
    }

    private static int[] histogram(int[] a, int m) {
        int[] ints = new int[m];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < m) {
                ints[a[i]]++;
            }
        }

        return ints;
    }
}
