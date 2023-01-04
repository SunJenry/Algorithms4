package org.sun.chapter1.section1.exe;

public class Exercise5 {
    public static void main(String[] args) {
        boolean a = isStrictlyBetween1And0(0.8, 1.32);
        System.out.println("a:" + a);
    }

    public static boolean isStrictlyBetween1And0(double arg1, double arg2) {
        if (arg1 > 0 && arg1 < 1 && arg2 > 0 && arg2 < 1) {
            return true;
        } else {
            return false;
        }
    }
}
