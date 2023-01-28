package org.sun.chapter1.section2.exe;

import org.sun.util.Interval1D;
import org.sun.util.StdOut;
import org.sun.util.StdRandom;

public class Exercise2 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Interval1D[] interval1DS = new Interval1D[n];

        genIntervals(interval1DS);

        calculateIntervals(interval1DS);
    }

    private static void calculateIntervals(Interval1D[] interval1DS) {
        for (int i = 0; i < interval1DS.length - 1; i++) {
            for (int j = i + 1; j < interval1DS.length; j++) {

                if (interval1DS[i].intersects(interval1DS[j])) {
                    StdOut.printf("Interval 1 - Min: %.3f  Max: %.3f \n", interval1DS[i].min(), interval1DS[i].max());
                    StdOut.printf("Interval 2 - Min: %.3f  Max: %.3f \n", interval1DS[j].min(), interval1DS[j].max());
                    StdOut.println();
                }
            }
        }
    }

    private static void genIntervals(Interval1D[] interval1DS) {
        for (int i = 0; i < interval1DS.length; i++) {

            double firstValue = StdRandom.uniform();
            double secondValue = StdRandom.uniform();

            if (firstValue > secondValue) {
                double temp = firstValue;
                firstValue = secondValue;
                secondValue = temp;
            }

            interval1DS[i] = new Interval1D(firstValue, secondValue);
        }
    }
}
