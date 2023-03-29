package org.sun.chapter2.section3.exe;

import org.sun.chapter2.section3.QuickSort;
import org.sun.util.StdOut;
import org.sun.util.StdRandom;
import org.sun.util.Util;

import java.util.Arrays;

import static org.sun.chapter2.section2.exe.Exe12.isSorted;

public class Exe11 {
    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(20);
        StdOut.println(Arrays.toString(comparables));
        sort(comparables);

        StdOut.println(Arrays.toString(comparables));

        isSorted(comparables);
    }

    public static void sort(Comparable[] array) {
        StdRandom.shuffle(array);

        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(Comparable[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int partition = partition(array, lo, hi);

        quicksort(array, lo, partition - 1);
        quicksort(array, partition + 1, hi);
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        Comparable pivot = array[lo];

        while (true) {
            while (array[++i].compareTo(pivot) <= 0) {
                if (i >= hi) break;
            }

            while (array[--j].compareTo(pivot) >= 0) {
                if (j <= lo) break;
            }

            if (i >= j) {
                break;
            }

            Comparable temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        Comparable temp = array[j];
        array[j] = array[lo];
        array[lo] = temp;

        return j;
    }
}
