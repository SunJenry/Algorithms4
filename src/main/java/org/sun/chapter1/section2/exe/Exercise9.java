package org.sun.chapter1.section2.exe;

import org.sun.chapter1.section2.Counter;

import java.util.Arrays;

public class Exercise9 {
    public static void main(String[] args) {
        int[] whitelist = {2, 10, 3, 6, 5, 4, 7, 1, 9, 8};

        //sort
        Arrays.sort(whitelist);

        int key = 10;
        Counter counter = new Counter("Operations");

        rank(whitelist, key, counter);
    }

    private static int rank(int[] whitelist, int key, Counter counter) {
        int lo = 0;
        int hi = whitelist.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            counter.increment();

            if (whitelist[mid] < key) {
                lo = mid + 1;
            } else if (whitelist[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
