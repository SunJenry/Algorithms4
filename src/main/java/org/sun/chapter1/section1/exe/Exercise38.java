package org.sun.chapter1.section1.exe;

public class Exercise38 {

    public static void main(String[] args) {

    }

    public static int bruteForceSearch(int key, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        int result = -1;

        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                result = i;
            }
        }

        return result;
    }

    public static int binarySearch(int key, int[] array, int lo, int hi) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        if (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (array[mid] > key) {
                return binarySearch(key, array, lo, mid - 1);
            } else if (array[mid] < key) {
                return binarySearch(key, array, mid + 1, hi);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}
