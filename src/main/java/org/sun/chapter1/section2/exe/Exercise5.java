package org.sun.chapter1.section2.exe;

import org.sun.util.StdOut;

public class Exercise5 {
    public static void main(String[] args) {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
        StdOut.println("Expected: Hello World");
    }
}
