package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;
import org.sun.util.StdRandom;

public class Exercise35 {

    public static final int SIDES = 6;

    public static void main(String[] args) {
        double[] standRate = diceRate();
        double[] diceExperiment = diceExperiment();
        for (int i = 2; i < SIDES * 2; i++) {
            StdOut.printf("%5.3f ", standRate[i]);
        }

        StdOut.println();

        for (int i = 2; i < SIDES * 2; i++) {
            StdOut.printf("%5.3f ", diceExperiment[i]);
        }

    }

    public static double[] diceRate() {

        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }

        for (int i = 2; i <= 2 * SIDES; i++) {
            dist[i] /= 36.0;
        }

        return dist;
    }

    public static double[] diceExperiment() {
        int N = 100000000;

        double[] doubles = new double[2 * SIDES + 1];

        for (int i = 0; i < N; i++) {
            int a = StdRandom.uniform(1, 7);
            int b = StdRandom.uniform(1, 7);

            doubles[a + b] += 1.0;
        }

        for (int i = 2; i <= 2 * SIDES; i++) {
            doubles[i] /= N;
        }

        return doubles;
    }
}
