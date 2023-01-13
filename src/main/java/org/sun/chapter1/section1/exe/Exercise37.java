package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

import static org.sun.chapter1.section1.exe.Exercise36.*;

public class Exercise37 {
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

            terribleShuffle(array);

            for (int j = 0; j < array.length; j++) {
                position[(int) array[j]][j]++;
            }
        }

        for (int i = 0; i < M; i++) {
            StdOut.println(Arrays.toString(position[i]));
        }
    }
}
