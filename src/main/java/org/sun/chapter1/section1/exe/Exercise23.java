package org.sun.chapter1.section1.exe;

import org.sun.util.StdIn;
import org.sun.util.StdOut;

public class Exercise23 {

    private static final char OPERATION_MINUS = '-';
    private static final char OPERATION_PLUS = '+';

    public static void main(String[] args) {
        char operation = '+';

        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int rank = Exercise22.rank(i, arr);

            if (operation == OPERATION_MINUS && rank != -1) {
                StdOut.println("Number in whitelist: " + i);
            } else if (operation == OPERATION_PLUS && rank == -1) {
                StdOut.println("Number not in whitelist: " + i);
            }
        }
    }
}
