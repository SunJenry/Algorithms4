package org.sun.chapter1.section4.exe;

import org.sun.util.StdOut;

public class Exe18 {
    public static void main(String[] args) {
        int[] array1 = {10, -9, 20, 25, 21, 40, 50, -20};
        int[] array2 = {-4, -3, 9, 4, 10, 2, 20};
        int[] array3 = {5, -3, -5, -6, -7, -8};
        int[] array4 = {5};
        int[] array5 = {10, 20};
        int[] array6 = {7, 20, 30};

        StdOut.println("Min Index:" + localMinimumIndex(array1));
        StdOut.println("Min Index:" + localMinimumIndex(array2));
        StdOut.println("Min Index:" + localMinimumIndex(array3));
        StdOut.println("Min Index:" + localMinimumIndex(array4));
        StdOut.println("Min Index:" + localMinimumIndex(array5));
        StdOut.println("Min Index:" + localMinimumIndex(array6));
    }

    public static int localMinimumIndex(int[] array) {

        int localMinimumIndex = -1;

        if (array.length <= 1) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid == 0) {
                if (array[0] < array[1]) {
                    localMinimumIndex = mid;
                }
                break;
            } else if (mid == array.length - 1) {
                if (array[mid] < array[mid - 1]) {
                    localMinimumIndex = mid;
                }
                break;
            } else if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                localMinimumIndex = mid;
                break;
            } else if (array[mid] > array[mid - 1]) {
                high = mid - 1;
            } else if (array[mid] > array[mid + 1]) {
                low = mid + 1;
            }
        }

        return localMinimumIndex;
    }
}
