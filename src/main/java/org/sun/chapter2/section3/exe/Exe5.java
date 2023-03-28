package org.sun.chapter2.section3.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

import static org.sun.chapter2.section2.exe.Exe12.isSorted;

public class Exe5 {
    public static void main(String[] args) {
        Integer[] integers = {4, 5, 5, 4, 5, 4, 4, 5, 5, 5, 5, 5, 4, 4, 4, 5, 4, 5, 4};

        sortTwoEleArray(integers);

        StdOut.println(Arrays.toString(integers));

        isSorted(integers);
    }

    public static void sortTwoEleArray(Comparable[] array) {
        int lo = 0;
        int lt = lo + 1;
        int gt = array.length - 1;

        Comparable pivot = array[0];

        while (lt <= gt) {
            if (array[lt].compareTo(pivot) <= 0) {
                Comparable temp = array[lo];
                array[lo] = array[lt];
                array[lt] = temp;

                lo++;
                lt++;

            } else {
                Comparable temp = array[gt];
                array[gt] = array[lt];
                array[lt] = temp;

                gt--;
            }

            StdOut.println(Arrays.toString(array));

        }
    }

}
