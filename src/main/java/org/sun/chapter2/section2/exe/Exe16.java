package org.sun.chapter2.section2.exe;

import org.sun.util.StdOut;
import org.sun.util.Util;

public class Exe16 {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            Comparable[] comparables = Util.generateRandomArray(2000);
            naturalMergeSort(comparables);
            Exe12.isSorted(comparables);
        }
    }

    public static void naturalMergeSort(Comparable[] array) {
        int sortedIndex = 0;
        int N = array.length;

        Comparable[] aux = new Comparable[N];

        while (sortedIndex < N) {
            int sortedIndex1;
            sortedIndex1 = sortedIndex;

            if (sortedIndex1 == N - 1) {
                //already sorted!!!
                StdOut.println("Already sorted!!!");
                break;
            }

            int sortedIndex2 = findSortedIndex(array, sortedIndex1 + 1);

            bottomUpMergeSort(array, 0, sortedIndex1, sortedIndex2, aux);

            sortedIndex = sortedIndex2;
        }
    }

    private static void bottomUpMergeSort(Comparable[] array, int lo, int mid, int hi, Comparable[] aux) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }

        int firstStart = lo;
        int secondStart = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (firstStart > mid) {
                array[i] = aux[secondStart++];
            } else if (secondStart > hi) {
                array[i] = aux[firstStart++];
            } else if (aux[firstStart].compareTo(aux[secondStart]) < 0) {
                array[i] = aux[firstStart++];
            } else {
                array[i] = aux[secondStart++];
            }
        }
    }

    private static int findSortedIndex(Comparable[] array, int startIndex) {
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                return i - 1;
            }
        }
        return array.length - 1;
    }
}
