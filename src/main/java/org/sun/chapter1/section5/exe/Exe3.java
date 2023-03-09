package org.sun.chapter1.section5.exe;

import org.sun.chapter1.section5.WeightQuickUnion;
import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe3 {
    public static void main(String[] args) {
        WeightQuickUnion weightQuickUnion = new WeightQuickUnion(10);
        weightQuickUnion.union(9, 0);
        //[9, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(3, 4);
        //[9, 1, 2, 3, 3, 5, 6, 7, 8, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(5, 8);
        //[9, 1, 2, 3, 3, 5, 6, 7, 5, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(7, 2);
        //[9, 1, 7, 3, 3, 5, 6, 7, 5, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(2, 1);
        //[9, 7, 7, 3, 3, 5, 6, 7, 5, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(5, 7);
        //[9, 7, 7, 3, 3, 7, 6, 7, 5, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(0, 3);
        //[9, 7, 7, 9, 3, 7, 6, 7, 5, 9]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
        weightQuickUnion.union(4, 2);
        //[9, 7, 7, 9, 3, 7, 6, 7, 5, 7]
        StdOut.println(Arrays.toString(weightQuickUnion.getIds()));
    }
}
