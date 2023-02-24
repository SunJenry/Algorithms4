package org.sun.chapter1.section4;

import java.math.BigInteger;

public class ThreeSum {

    public static int count(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    BigInteger sum = BigInteger.valueOf(array[i]).add(BigInteger.valueOf(array[j])).add(BigInteger.valueOf(array[k]));

                    if (sum.compareTo(BigInteger.ZERO) == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
