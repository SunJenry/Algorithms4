package org.sun.chapter1.section5.exe;

import org.sun.chapter1.section5.QuickFind;
import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe1 {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(9, 0);
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 0]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(3, 4);
        //[0, 1, 2, 4, 4, 5, 6, 7, 8, 0]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(5, 8);
        //[0, 1, 2, 4, 4, 8, 6, 7, 8, 0]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(7, 2);
        //[0, 1, 2, 4, 4, 8, 6, 2, 8, 0]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(2, 1);
        //[0, 1, 1, 4, 4, 8, 6, 1, 8, 0]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(5, 7);
        //[0, 1, 1, 4, 4, 1, 6, 1, 1, 0]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(0, 3);
        //[4, 1, 1, 4, 4, 1, 6, 1, 1, 4]
        StdOut.println(Arrays.toString(quickFind.getIds()));
        quickFind.union(4, 2);
        //[1, 1, 1, 1, 1, 1, 6, 1, 1, 1]
        StdOut.println(Arrays.toString(quickFind.getIds()));
    }
}
