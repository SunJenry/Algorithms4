package org.sun.chapter1.section1.exe;

import org.sun.util.In;
import org.sun.util.StdOut;

public class Exercise21 {
    public static void main(String[] args) {
        In in = new In();
        while (in.hasNextLine()) {
            String line = in.readLine();
            if (line.isEmpty() || line.isBlank()) {
                break;
            }
            String[] split = line.split(" ");
            printInfo(split);
        }
    }

    private static void printInfo(String[] split) {
        String value0 = split[0];
        String value1 = split[1];
        String value2 = split[2];

        StdOut.printf("%8s", value0);
        StdOut.printf("%8s", value1);
        StdOut.printf("%8s", value2);

        double parseValue1 = Double.parseDouble(value1);
        double parseValue2 = Double.parseDouble(value2);

        double result = parseValue1 / parseValue2;

        StdOut.printf("%7.3s", result);
    }
}
