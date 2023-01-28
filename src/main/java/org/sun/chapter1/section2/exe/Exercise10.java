package org.sun.chapter1.section2.exe;

import org.sun.util.StdDraw;

public class Exercise10 {
    public static void main(String[] args) {

    }

    public static class VisualCounter {

        private int N;
        private int max;

        private int operationCount = 0;
        private int currentValue = 0;

        public VisualCounter(int n, int max) {
            N = n;
            this.max = max;
        }

        public void increment() {
            if (operationCount < N && Math.abs(currentValue) < max) {
                operationCount++;
                currentValue++;

                plotCounter();
            }
        }

        public void decrement() {
            if (operationCount < N && Math.abs(currentValue) < max) {
                operationCount++;
                currentValue--;

                plotCounter();
            }
        }

        private void plotCounter() {
            StdDraw.point(operationCount, currentValue);
        }
    }
}
