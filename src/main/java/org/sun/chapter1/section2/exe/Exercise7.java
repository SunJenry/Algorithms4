package org.sun.chapter1.section2.exe;

import org.sun.util.StdOut;

public class Exercise7 {
    public static void main(String[] args) {
        String s = "calculate";
        String mystery = mystery(s);
        StdOut.printf("%s - %s", s, mystery);
    }

    /**
     * return a mirror string
     *
     * @param s
     * @return
     */
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }
}
