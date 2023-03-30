package org.sun.chapter2.section3.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe15 {
    public static void main(String[] args) {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        matchPair(nuts, bolts);

        StdOut.println(Arrays.toString(nuts));
        StdOut.println(Arrays.toString(bolts));

    }

    private static void matchPair(char[] nuts, char[] bolts) {
        matchPair(nuts, bolts, 0, nuts.length - 1);
    }

    private static void matchPair(char[] nuts, char[] bolts, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        char boltPivot = bolts[lo];

        StdOut.println("boltPivot:" + boltPivot);

        int partitionNut = partition(nuts, lo, hi, boltPivot);
        StdOut.println("Nuts:" + Arrays.toString(nuts));

        int partitionBolt = partition(bolts, lo, hi, nuts[partitionNut]);
        StdOut.println("Bolts:" + Arrays.toString(bolts));

        StdOut.println("partitionNut:" + partitionNut + " partitionBolt:" + partitionBolt);

        matchPair(nuts, bolts, lo, partitionNut - 1);
        matchPair(nuts, bolts, partitionNut + 1, hi);
    }

    private static int partition(char[] array, int lo, int hi, char boltPivot) {
        int i = lo;
        int leftStart = lo;
        int j = hi;

        while (leftStart <= j) {
            char nutI = array[leftStart];
            if (nutI < boltPivot) {
                if (i != leftStart) {
                    char temp = array[i];
                    array[i] = array[leftStart];
                    array[leftStart] = temp;
                }

                i++;
                leftStart++;
            } else if (nutI > boltPivot) {
                char temp = array[j];
                array[j] = array[leftStart];
                array[leftStart] = temp;
                j--;
            } else {
                leftStart++;
            }
        }

        return i;
    }
}
