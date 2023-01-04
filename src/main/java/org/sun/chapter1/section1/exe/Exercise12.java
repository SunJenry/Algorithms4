package org.sun.chapter1.section1.exe;

import java.util.Arrays;

public class Exercise12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        System.out.println("a[]:" + Arrays.toString(a));

        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }

        System.out.println("a[]:" + Arrays.toString(a));

        for (int i = 0; i < 10; i++) {
            System.out.print(i + ",");
        }
    }
}
