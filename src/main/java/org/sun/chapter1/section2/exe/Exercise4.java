package org.sun.chapter1.section2.exe;

import org.sun.util.StdOut;

public class Exercise4 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1 + " Expected: world");
        StdOut.println(string2 + " Expected: hello");
    }
}
