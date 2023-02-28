package org.sun.chapter1.section4.exe;

import org.sun.util.StdOut;

public class Exe12 {
    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 2, 5, 6, 6, 8, 25, 25};
        int[] array2 = {-2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25};

        printTwoSortedArray(array1, array2);
    }

    public static void printTwoSortedArray(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int index1 = 0;
        int index2 = 0;

        while (index1 < length1 || index2 < length2) {
            if (index1 >= length1) {
                StdOut.print(array2[index2++]);
            } else if (index2 >= length2) {
                StdOut.print(array1[index1++]);
            } else if (array1[index1] <= array2[index2]) {
                StdOut.print(array1[index1++]);
            } else {
                StdOut.print(array2[index2++]);
            }

            StdOut.print(" ");
        }
    }
}
