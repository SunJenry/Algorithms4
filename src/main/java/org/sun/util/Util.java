package org.sun.util;

public class Util {
    public static Comparable[] generateRandomArray(int arrayLength) {
        Comparable[] array = new Comparable[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = StdRandom.uniformInt(arrayLength);
        }

        return array;
    }

    public static Integer[] generateRandomArray(int arrayLength,int upperBound) {
        Integer[] array = new Integer[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = StdRandom.uniformInt(upperBound);
        }

        return array;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
