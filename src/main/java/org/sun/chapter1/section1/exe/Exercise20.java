package org.sun.chapter1.section1.exe;

public class Exercise20 {
    public static void main(String[] args) {
        int N = 20;
        double v = lnFactorial(20);
        System.out.println("ln(" + N + "!)=" + v);
    }

    public static double lnFactorial(int n) {
        if (n == 1) return 0;
        return Math.log(n) + lnFactorial(n - 1);
    }
}
