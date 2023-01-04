package org.sun.chapter1.section1.exe;

public class Exercise6 {
    public static void main(String[] args) {
        //Obviously, it's Fibonacci.
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println("f:" + f);
            f = f + g;
            g = f - g;
        }
    }
}
