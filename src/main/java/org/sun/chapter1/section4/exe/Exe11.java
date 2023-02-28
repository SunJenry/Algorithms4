package org.sun.chapter1.section4.exe;

import org.sun.chapter1.section2.StaticSEofInts;
import org.sun.util.StdOut;

public class Exe11 {
    public static void main(String[] args) {
        int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};
        StaticSEofInts staticSEofInts = new StaticSEofInts(testArray1);
        StdOut.println("How many 4:"+staticSEofInts.howMany(4));
        StdOut.println("How many 20:"+staticSEofInts.howMany(20));
    }
}
