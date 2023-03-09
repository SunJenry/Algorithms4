package org.sun.chapter1.section5.exe;

import org.sun.chapter1.section5.QuickUnion;
import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe2 {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(9, 0);
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(3, 4);
        //[0, 1, 2, 4, 4, 5, 6, 7, 8, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(5, 8);
        //[0, 1, 2, 4, 4, 8, 6, 7, 8, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(7, 2);
        //[0, 1, 2, 4, 4, 8, 6, 2, 8, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(2, 1);
        //[0, 1, 1, 4, 4, 8, 6, 2, 8, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(5, 7);
        //[0, 1, 1, 4, 4, 8, 6, 2, 1, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(0, 3);
        //[4, 1, 1, 4, 4, 8, 6, 2, 1, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
        quickUnion.union(4, 2);
        //[4, 1, 1, 4, 1, 8, 6, 2, 1, 0]
        StdOut.println(Arrays.toString(quickUnion.getIds()));
    }
}
