package org.sun.chapter1.section1.exe;

public class Exercise14 {
    public static void main(String[] args) {
        int n = 15;
        int lg = lg(n);
        System.out.println("N:" + n + " lg:" + lg);
    }

    private static int lg(int n) {
        int temp = 1;
        int maxLg = -1;
        while (temp <= n) {
            maxLg++;
            temp *= 2;
        }

        return maxLg;
    }
}
