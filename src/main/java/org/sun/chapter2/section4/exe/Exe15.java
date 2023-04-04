package org.sun.chapter2.section4.exe;

import org.sun.util.StdOut;
import org.sun.util.Util;

import java.util.Arrays;

public class Exe15 {
    public static void main(String[] args) {
        String[] split = "Y, T, U, S, Q, N, E, A, S, I, O, E".split(", ");
        String[] strings = new String[split.length + 1];
        strings[0] = null;
        for (int i = 0; i < split.length; i++) {
            strings[i + 1] = split[i];
        }
        boolean b = maxHeapArrayVerify(strings);
        StdOut.println("maxHeapVerify:" + b);
    }

    public static boolean maxHeapArrayVerify(Comparable[] pq) {
        for (int i = 1; i < pq.length / 2; i++) {
            if (Util.less(pq[i], pq[2 * i])) {
                return false;
            }

            if ((2 * i + 1 < pq.length) && Util.less(pq[i], pq[2 * i + 1])) {
                return false;
            }
        }

        return true;
    }
}
