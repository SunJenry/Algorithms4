package org.sun.chapter1.section1.exe;

import org.sun.util.StdRandom;

public class Exercise39 {
    public static void main(String[] args) {

    }

    public static int bothExistCount(int N) {
        int[] ints1 = new int[N];
        int[] ints2 = new int[N];

        for (int i = 0; i < N; i++) {
            ints1[i] = StdRandom.uniform(100000, 1000000);
            ints2[i] = StdRandom.uniform(100000, 1000000);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int i1 = Exercise38.binarySearch(ints1[i], ints2, 0, N);
            if (i1 != -1) {
                count++;
            }
        }

        return count;
    }
}
