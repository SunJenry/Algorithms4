package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

public class Exercise24 {
    public static void main(String[] args) {
        int gcd = gcd(105, 24);

        StdOut.println("GDC 1: " + gcd);
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }
}
