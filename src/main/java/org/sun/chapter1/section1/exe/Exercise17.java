package org.sun.chapter1.section1.exe;

public class Exercise17 {
    public static void main(String[] args) {
        /**
         * Exception in thread "main" java.lang.StackOverflowError
         * 	at org.sun.chapter1.section1.exe.Exercise17.exR2(Exercise17.java:9)
         * 	at org.sun.chapter1.section1.exe.Exercise17.exR2(Exercise17.java:9)
         * 	at org.sun.chapter1.section1.exe.Exercise17.exR2(Exercise17.java:9)
         * 	at org.sun.chapter1.section1.exe.Exercise17.exR2(Exercise17.java:9)
         */
        exR2(6);
    }

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }
}
