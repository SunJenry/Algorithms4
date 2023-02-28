package org.sun.chapter1.section4.exe;

import org.sun.util.StdOut;

public class Exe10 {
    public static void main(String[] args) {
        int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};

        int i = binarySearchSmallestIndex(testArray1, 20, 0, testArray1.length);

        StdOut.println("smallest index:"+i);

    }

    public static int binarySearchSmallestIndex(int[] arrays, int element, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (arrays[mid] > element) {
            return binarySearchSmallestIndex(arrays, element, low, mid - 1);
        } else if (arrays[mid] < element) {
            return binarySearchSmallestIndex(arrays, element, mid + 1, high);
        } else {
            int possibleSmallestIndex = binarySearchSmallestIndex(arrays, element, low, mid - 1);

            if (possibleSmallestIndex == -1) {
                return mid;
            } else {
                return possibleSmallestIndex;
            }
        }
    }
}
