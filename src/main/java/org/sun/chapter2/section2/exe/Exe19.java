package org.sun.chapter2.section2.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe19 {
    public static void main(String[] args) {
        int size = 10;
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }

        int inversion = inversion(array);
        StdOut.println("InversionCount:" + inversion);
    }

    public static int inversion(Comparable[] array) {
        Comparable[] arraysCopy = Arrays.copyOf(array, array.length);

        Comparable[] aux = new Comparable[arraysCopy.length];

        return countInversion(arraysCopy, 0, arraysCopy.length - 1, aux);
    }

    private static int countInversion(Comparable[] array, int lo, int hi, Comparable[] aux) {
        if (lo >= hi) {
            return 0;
        }

        int mid = (lo + hi) / 2;

        int countFirstHalf = countInversion(array, lo, mid, aux);
        int countSecondHalf = countInversion(array, mid + 1, hi, aux);

        return countFirstHalf + countSecondHalf + countInversion(array, lo, mid, hi, aux);
    }

    private static int countInversion(Comparable[] array, int lo, int mid, int hi, Comparable[] aux) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }

        int firstStart = lo;
        int secondStart = mid + 1;
        int current = lo;

        int count = 0;

        while (firstStart <= mid && secondStart <= hi) {
            if (aux[firstStart].compareTo(aux[secondStart]) > 0) {
                array[current++] = aux[secondStart++];
                count += mid - firstStart + 1;
            } else {
                array[current++] = aux[firstStart++];
            }
        }

        while (firstStart <= mid) {
            array[current++] = aux[firstStart++];
        }

        return count;
    }
}
