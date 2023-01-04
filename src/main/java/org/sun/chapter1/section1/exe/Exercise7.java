package org.sun.chapter1.section1.exe;

public class Exercise7 {
    public static void main(String[] args) {
        methodA();

        methodB();

        methodC();
    }

    private static void methodC() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println("sum:" + sum);
    }

    private static void methodB() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println("sum:" + sum);
    }

    private static void methodA() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.01) {
            t = (9.0 / t + t) / 2.0;
            System.out.println(t);
        }

        System.out.println(t);
    }
}
