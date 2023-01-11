package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

public class Exercise26 {
    public static void main(String[] args) {
        int a = 123;
        int b = 234;
        int c = 145;

        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }

        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        StdOut.print("a:" + a + " b:" + b + " c:" + c);
    }
}
