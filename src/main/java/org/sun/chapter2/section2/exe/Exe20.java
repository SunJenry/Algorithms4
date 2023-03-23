package org.sun.chapter2.section2.exe;

import org.sun.util.StdOut;
import org.sun.util.StdRandom;

import java.util.Arrays;

public class Exe20 {
    public static void main(String[] args) {
        int N = 200;
        Integer[] integers = new Integer[N];
        for (int i = 0; i < N; i++) {
            integers[i] = StdRandom.uniformInt(N);
        }

        StdOut.println(Arrays.toString(integers));

        int[] index = indexSort(integers);

        StdOut.println(Arrays.toString(index));

        Integer[] sorted = new Integer[N];
        for (int i = 0; i < N; i++) {
            StdOut.print(integers[index[i]] + ", ");
            sorted[i] = integers[index[i]];
        }

        StdOut.println();

        Exe12.isSorted(sorted);
    }

    public static int[] indexSort(Comparable[] comparables) {
        int[] index = new int[comparables.length];

        for (int i = 0; i < comparables.length; i++) {
            index[i] = i;
        }

        int[] aux = Arrays.copyOf(index, index.length);

        indexSort(comparables, index, aux, 0, comparables.length - 1);

        return index;
    }

    private static void indexSort(Comparable[] comparables, int[] index, int[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;

        indexSort(comparables, index, aux, lo, mid);
        indexSort(comparables, index, aux, mid + 1, hi);

        mergeIndexSort(comparables, index, aux, lo, mid, hi);
    }

    private static void mergeIndexSort(Comparable[] comparables, int[] index, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = index[i];
        }

        int firstStart = lo;
        int secondStart = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (firstStart > mid) {
                index[i] = aux[secondStart++];
            } else if (secondStart > hi) {
                index[i] = aux[firstStart++];
            } else if (comparables[aux[firstStart]].compareTo(comparables[aux[secondStart]]) < 0) {
                index[i] = aux[firstStart++];
            } else {
                index[i] = aux[secondStart++];
            }
        }
    }
}
