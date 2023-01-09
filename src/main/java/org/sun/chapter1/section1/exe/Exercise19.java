package org.sun.chapter1.section1.exe;

public class Exercise19 {
    public static void main(String[] args) {

        int n = 40;

        long t = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            long values[];
            if (i == 0 || i == 1) {
                values = new long[2];
            } else {
                values = new long[n + 1];
            }

            values[0] = 0;
            values[1] = 1;
            System.out.println(i + " " + F(values, i));
        }
        System.out.println("Total time:" + (System.currentTimeMillis() - t));


        long t1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + F(i));
        }
        System.out.println("Total time:" + (System.currentTimeMillis() - t1));
    }

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long F(long[] values, int n) {
        if (n == 0) values[0] = 0;
        if (n == 1) values[1] = 1;

        for (int i = 2; i <= n; i++) {
            values[i] = values[i - 1] + values[i - 2];
        }

        return values[n];
    }
}
