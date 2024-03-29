package org.sun.chapter2.section2.exe;

public class Exe8 {
    public static void main(String[] args) {
        /**
         * Since the array is already sorted, merge() will always be skipped. So there won't be any values copied from the aux array to the original array (only values copied from the original array to the aux array).
         * Therefore, there will be only 1 compare for every subarray, which is a linear operation.
         *
         * When N is a power of 2, the number of compares will satisfy the recurrence
         * T(N) = 2 T(N/2) + 1, with T(1) = 0
         */
    }
}
