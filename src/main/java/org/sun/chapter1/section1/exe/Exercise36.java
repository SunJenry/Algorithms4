package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;
import org.sun.util.StdRandom;

import java.util.Arrays;

public class Exercise36 {

    public static void main(String[] args) {
        shuffleCheck();
    }

    private static void shuffleCheck() {
        int M = 10;
        int N = 100000000;

        double[][] position = new double[M][M];

        double[] array = new double[M];

        for (int i = 0; i < N; i++) {
            initArray(array);

            shuffleArray(array);

            for (int j = 0; j < array.length; j++) {
                position[(int) array[j]][j]++;
            }
        }

        for (int i = 0; i < M; i++) {
            StdOut.println(Arrays.toString(position[i]));
        }
    }

    public static void shuffleArray(double[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniform(n - i);     // between i and n-1
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void terribleShuffle(double[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(n);     // between 0 and n-1
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void initArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}
