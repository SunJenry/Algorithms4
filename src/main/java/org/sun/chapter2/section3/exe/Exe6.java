package org.sun.chapter2.section3.exe;

import org.sun.util.StdOut;
import org.sun.util.Util;

import static org.sun.chapter2.section2.exe.Exe12.isSorted;

public class Exe6 {

    private static int compareNum = 0;

    public static void main(String[] args) {
        int length[] = {100, 1000, 10000};
        for (int i = 0; i < length.length; i++) {
            compareNum = 0;

            Comparable[] comparables = Util.generateRandomArray(length[i]);
            sort(comparables);
            isSorted(comparables);

            StdOut.println("2NlnN:" + (2 * length[i] * Math.log(length[i])));
            StdOut.println("compareNum:" + compareNum);
        }
    }

    public static void sort(Comparable[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(Comparable[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int partition = partition(array, lo, hi);

        quicksort(array, lo, partition - 1);
        quicksort(array, partition + 1, hi);
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        Comparable pivot = array[lo];

        int i = lo;
        int j = hi + 1;

        while (i < j) {

            compareNum++;

            while (array[++i].compareTo(pivot) < 0) {
                compareNum++;
                if (i >= hi) break;
            }

            compareNum++;

            while (array[--j].compareTo(pivot) > 0) {
                compareNum++;
                if (j <= lo) break;
            }

            if (i > j) break;

            Comparable temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        array[lo] = array[j];
        array[j] = pivot;

        return j;
    }
}
