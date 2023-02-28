package org.sun.chapter1.section4.exe;

import java.util.Arrays;

public class Exe8 {
    public static void main(String[] args) {

    }

    public static int countOfPairs(int[] values) {
        Arrays.sort(values);

        int count = 0;

        int equalValueCount = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] == values[i]) {
                equalValueCount++;
            } else {
                if (equalValueCount != 1) {
                    count += equalValueCount * (equalValueCount - 1) / 2;
                    equalValueCount = 1;
                }
            }
        }

        if (equalValueCount != 1) {
            count += equalValueCount * (equalValueCount - 1) / 2;
        }

        return count;
    }
}
