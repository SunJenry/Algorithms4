package org.sun.chapter1.section2.exe;

public class Exercise8 {
    public static void main(String[] args) {
        int[] a = new int[1000000];
        int[] b = new int[1000000];
        int[] t = a;
        a = b;
        b = t;

        //swap value in a and b
    }
}
