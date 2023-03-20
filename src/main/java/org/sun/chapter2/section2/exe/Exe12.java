package org.sun.chapter2.section2.exe;

import org.sun.util.StdOut;
import org.sun.util.Util;

public class Exe12 {
    public static void main(String[] args) {
        int M = 5;
        int N = 200;

        if (N % M != 0) {
            throw new IllegalArgumentException();
        }

        Comparable[] comparables = Util.generateRandomArray(N);

        int blockCount = N / M;

        for (int i = 0; i < blockCount; i++) {
            sort(comparables, i * M, (i + 1) * M - 1);
        }

        Comparable[] aux = new Comparable[M];

        for (int i = blockCount - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int lo = j * M;
                int mid = lo + M - 1;
                int hi = mid + M;

                merge(comparables, lo, mid, hi, aux);
            }
        }

        isSorted(comparables);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
        int auxIndex = 0;
        for (int i = lo; i <= mid; i++) {
            aux[auxIndex++] = a[i];
        }

        int aIndex = lo;
        int hiIndex = mid + 1;

        auxIndex = 0;

        while (auxIndex < aux.length && hiIndex <= hi) {
            if (less(aux[auxIndex], a[hiIndex])) {
                a[aIndex++] = aux[auxIndex++];
            } else {
                a[aIndex++] = a[hiIndex++];
            }
        }

        while (auxIndex < aux.length) {
            a[aIndex++] = aux[auxIndex++];
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                Comparable temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                StdOut.println("Not Sorted!!");
                return false;
            }
        }

        StdOut.println("Sorted!!");

        return true;
    }
}
