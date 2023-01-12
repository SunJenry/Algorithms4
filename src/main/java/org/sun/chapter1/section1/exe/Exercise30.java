package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

public class Exercise30 {
    public static void main(String[] args) {
        int N = 10;
        boolean[][] arrays = new boolean[N][N];

        fillData(N, arrays);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.printf("%6b", arrays[i][j]);
            }
            StdOut.println();
        }
    }

    private static void fillData(int n, boolean[][] arrays) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrays[i][j] = isCoprime(i, j);
            }
        }
    }

    public static boolean isCoprime(int i, int j) {
        if (i == 0 || j == 0) {
            return handleZero(i, j);
        }

        return Exercise24.gcd(i, j) == 1;
    }

    private static boolean handleZero(int i, int j) {
        return (i == 0 && j == 1) || (i == 0 && j == -1) || (j == 0 && i == 1) || (j == 0 && i == -1);
    }
}
