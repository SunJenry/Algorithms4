package org.sun.chapter1.section4.exe;

import java.util.Arrays;

public class Exe16 {
    public static void main(String[] args) {

    }

    public static double[] closestPair(double[] array) {
        Arrays.sort(array);

        double min = Double.MAX_VALUE;

        double[] pair = new double[2];

        for (int i = 1; i < array.length; i++) {
            double gap = array[i] - array[i - 1];
            if (gap < min) {
                min = gap;
                pair[0] = array[i - 1];
                pair[1] = array[i];
            }
        }

        return pair;
    }
}
