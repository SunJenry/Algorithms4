package org.sun.chapter1.section4.exe;

public class Exe17 {
    public static void main(String[] args) {

    }

    public static double[] farthestPair(double[] array) {
        double[] pair = new double[2];

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double key : array) {
            if (key > max) {
                max = key;
            }

            if (key < min) {
                min = key;
            }
        }

        pair[0] = min;
        pair[1] = max;

        return pair;
    }
}
