package org.sun.chapter1.section4.exe;

import org.sun.util.StdOut;

public class Exe20 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, -1, -2, -3};
        int[] array2 = {1, 5, 4, 3, 2, 0};
        int[] array3 = {2, 4, 8, 16, 32, 1};
        int[] array4 = {2, 4, 8, 16, 32};
        int[] array5 = {2, 1};
        int[] array6 = {9};

        StdOut.println("tipping point:" + findTippingPointIndex(array1));
        StdOut.println("tipping point:" + findTippingPointIndex(array2));
        StdOut.println("tipping point:" + findTippingPointIndex(array3));
        StdOut.println("tipping point:" + findTippingPointIndex(array4));
        StdOut.println("tipping point:" + findTippingPointIndex(array5));
        StdOut.println("tipping point:" + findTippingPointIndex(array6));

        StdOut.println("bitonic:" + bitonicSearch(array1, -1));
        StdOut.println("bitonic:" + bitonicSearch(array2, 5));
        StdOut.println("bitonic:" + bitonicSearch(array3, 2));
        StdOut.println("bitonic:" + bitonicSearch(array3, 99));
        StdOut.println("bitonic:" + bitonicSearch(array4, 32));
        StdOut.println("bitonic:" + bitonicSearch(array5, 1));
        StdOut.println("bitonic:" + bitonicSearch(array6, 9));
    }

    public static int bitonicSearch(int[] array, int key) {

        int keyIndex = -1;

        int tippingPointIndex = findTippingPointIndex(array);

        if (key > array[tippingPointIndex]) {
            //not in the array, do nothing
        } else if (key == array[tippingPointIndex]) {
            keyIndex = tippingPointIndex;
        } else if (key < array[tippingPointIndex]) {
            int keyIndexDescending = searchInDescending(array, tippingPointIndex + 1, array.length - 1, key);

            if (keyIndexDescending != -1) {
                keyIndex = keyIndexDescending;
            } else {
                keyIndex = searchInAscending(array, 0, tippingPointIndex - 1, key);
            }
        }

        return keyIndex;
    }

    public static int searchInDescending(int[] array, int low, int high, int key) {
        int keyIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midValue = array[mid];

            if (midValue > key) {
                low = mid + 1;
            } else if (midValue < key) {
                high = mid - 1;
            } else {
                //find it!!!
                keyIndex = mid;
                break;
            }
        }

        return keyIndex;
    }

    private static int searchInAscending(int[] array, int low, int high, int key) {
        int keyIndex = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            int midValue = array[mid];

            if (midValue > key) {
                high = mid - 1;
            } else if (midValue < key) {
                low = mid + 1;
            } else {
                //find it!
                keyIndex = mid;
                break;
            }
        }

        return keyIndex;
    }

    private static int findTippingPointIndex(int[] array) {
        int low = 0;
        int high = array.length - 1;

        int tippingPointIndex = array.length - 1;

        while (low <= high) {

            if (low == high) {
                tippingPointIndex = low;
                break;
            }

            int mid = (low + high) / 2;


            int midPreValue = Integer.MIN_VALUE;
            if (mid - 1 >= 0) {
                midPreValue = array[mid - 1];
            }

            int midValue = array[mid];

            int midNextValue = Integer.MIN_VALUE;
            if (mid + 1 < array.length) {
                midNextValue = array[mid + 1];
            }

            if (midPreValue < midValue && midValue < midNextValue) {
                //ascending
                low = mid + 1;
            } else if (midPreValue > midValue && midValue > midNextValue) {
                //descending
                high = mid - 1;
            } else {
                //find tipping point
                tippingPointIndex = mid;
                break;
            }
        }

        return tippingPointIndex;
    }
}
