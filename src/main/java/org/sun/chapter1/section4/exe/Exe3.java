package org.sun.chapter1.section4.exe;

import org.sun.chapter1.section4.ThreeSum;
import org.sun.util.StdOut;
import org.sun.util.StdRandom;
import org.sun.util.Stopwatch;

public class Exe3 {
    public static void main(String[] args) {
        for (int n = 250; true; n += n) {
            // Print time for problem size n
            double time = timeTrial(n);

            StdOut.printf("%7d %5.1f\n", n, time);
        }
    }

    public static double timeTrial(int n) {
        // Time ThreeSum.count() for N random 6-digit ints.
        int MAX = 1000000;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(array);
        return timer.elapsedTime();
    }
}
