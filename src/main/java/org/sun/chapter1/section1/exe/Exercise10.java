package org.sun.chapter1.section1.exe;

public class Exercise10 {
    public static void main(String[] args) {
        int[] a;
        for (int i = 0; i < 10; i++) {
            //error: variable a might not have been initialized a[i] = i * i;
//            a[i] = i * i;
        }
    }
}
