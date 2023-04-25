package org.sun.chapter3.section2.exe;

public class Exe8 {
    public static void main(String[] args) {

    }

    private static double optCompares(int n) {
        if (n == 0) {
            return 0;
        }
        int height = (int) (Math.log(n) / Math.log(2));
        return ((n + 1) * height - Math.pow(2, height + 1) + 2) / n + 1;
    }
}
