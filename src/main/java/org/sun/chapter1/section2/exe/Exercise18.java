package org.sun.chapter1.section2.exe;

import org.sun.util.StdOut;

public class Exercise18 {
    private double m;
    private double s;
    private int N;

    public void addDataValue(double x) {
        N++;
        s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }

    public double mean() {
        return m;
    }

    public double var() {
        return s / (N - 1);
    }

    public double stddev() {
        return Math.sqrt(this.var());
    }

    public static void main(String...args) {
        //Code validation
        Exercise18 validation = new Exercise18();
        validation.addDataValue(2);
        validation.addDataValue(4);
        validation.addDataValue(5);

        StdOut.println("Mean: " + validation.mean() + " Expected: 3.6666666666666665");
        StdOut.println("Variance: " + validation.var() + " Expected:  2.333333333333333");
        StdOut.println("Standard Deviation: " + validation.stddev() + " Expected: 1.5275252316519465");
    }
}
