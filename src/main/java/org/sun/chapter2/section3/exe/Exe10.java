package org.sun.chapter2.section3.exe;

public class Exe10 {
    public static void main(String[] args) {
        /**
         *  N = 1,000,000
         *  quicksort uses ~2N ln N = 27,620,000 compares
         *  the standard deviation of the number of compares is about .65 N = 650,000
         *
         *  Difference between target compares and average compares = 100,000,000,000 - 27,620,000 = 99,972,380,000
         * k = number of standard deviations = 99,972,380,000 / 650,000 ~= 153,804
         *
         * P < 1 / k^2
         * P < 1 / (153,804)^2
         * P < 1 / 23,655,670,416
         * P < 0.000000000042273 = 0.0000000042273%
         *
         * get this answer from Rene Argento
         */
    }
}
