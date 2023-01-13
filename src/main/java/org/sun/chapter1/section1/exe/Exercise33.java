package org.sun.chapter1.section1.exe;

public class Exercise33 {
    public static void main(String[] args) {

    }

    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length) {
            throw new IllegalArgumentException();
        }

        double result = 0;

        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }

        return result;
    }

    public static double[][] mult(double[][] x, double[][] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0 || x[0].length != y.length) {
            throw new IllegalArgumentException();
        }

        double[][] c = new double[x.length][y[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < x[0].length; k++) {
                    c[i][j] += x[i][k] * y[k][j];
                }
            }
        }

        return c;
    }

    public static double[] mult(double[][] x, double[] y) {
        if (x == null || y == null || x[0].length != y.length) {
            throw new IllegalArgumentException();
        }

        double[] b = new double[x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                b[i] += x[i][j] * y[j];
            }
        }

        return b;
    }

    public static double[] mult(double[] y, double[][] a) {
        if (a == null || y == null || a.length != y.length) {
            throw new IllegalArgumentException();
        }

        double[] b = new double[a[0].length];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < y.length; j++) {
                b[i] += a[j][i] * y[j];
            }
        }

        return b;
    }

    public static double[][] transpose(double[][] x) {
        if (x == null) throw new IllegalArgumentException();

        if (x.length == 0) {
            return x;
        }

        double[][] temp = new double[x[0].length][x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                temp[j][i] = x[i][j];
            }
        }

        return temp;
    }
}
