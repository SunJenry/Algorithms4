package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Stack;
import org.sun.util.StdOut;

public class Exercise5 {
    public static void main(String[] args) {
        decimalToBinary(50);
        decimalToBinary(8);
    }

    /**
     * Decimal to Binary
     * 十进制转二进制
     *
     * @param n
     */
    public static void decimalToBinary(int n) {
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        for (int d : stack) {
            StdOut.print(d);
        }

        StdOut.println();
    }
}
