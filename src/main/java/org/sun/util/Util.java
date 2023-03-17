package org.sun.util;

public class Util {
    public static Comparable[] generateRandomArray(int arrayLength) {
        Comparable[] array = new Comparable[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = StdRandom.uniformInt(arrayLength);
        }

        return array;
    }
}
