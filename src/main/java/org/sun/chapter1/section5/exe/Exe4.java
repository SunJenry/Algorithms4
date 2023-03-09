package org.sun.chapter1.section5.exe;

import org.sun.chapter1.section5.WeightQuickUnion;
import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe4 {
    public static void main(String[] args) {
        WeightQuickUnion weightQuickUnion = new WeightQuickUnion(10);
        weightQuickUnion.union(9, 0);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(3, 4);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(5, 8);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(7, 2);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(2, 1);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(5, 7);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(0, 3);
        printIdAndSize(weightQuickUnion);
        weightQuickUnion.union(4, 2);
        printIdAndSize(weightQuickUnion);
    }

    private static void printIdAndSize(WeightQuickUnion weightQuickUnion) {
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        StdOut.println(Arrays.toString(weightQuickUnion.getSize()));
        StdOut.println();
    }
}
