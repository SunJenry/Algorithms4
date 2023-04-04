package org.sun.chapter2.section4.exe;

public class Exe13 {
    public static void main(String[] args) {
        /**
         *     private void sink(int k) {
         *         while (2 * k <= N) {
         *             int j = 2 * k;
         *             if (j < N && less(j, j + 1)) j++;
         *             if (!less(k, j)) break;
         *             exch(k, j);
         *             k = j;
         *         }
         *     }
         *
         *     private void sink(int k) {
         *     while (2*k < N) {
         *         int j = 2*k;
         *         if (less(j, j+1)) j++;
         *         if (!less(k, j)) break;
         *         exch(k, j);
         *         k = j;
         *     }
         *
         *      **************************************************
         *     //If we reached the n-1 level of the heap and it only has 1 child (the left child), we need one more verification
         *     if (2 * k == N) {
         *         //If the current element is smaller than its child, exchange them
         *         if (less(k, 2 * k)) {
         *             exch(k, 2 * k);
         *         }
         *     }
         *
         *    ***********************************************
         * }
         */
    }
}
