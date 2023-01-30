package org.sun.chapter1.section2.exe;

import org.sun.util.In;
import org.sun.util.StdIn;

public class Exercise15 {
    public static void main(String[] args) {

    }

    public static int[] readInts(String fileName) {
        In in = new In(fileName);
        String all = StdIn.readAll();
        String[] words = all.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }

        return ints;
    }
}
