package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Stack;

public class Exercise45 {
    public static void main(String[] args) {

    }

    public static boolean willStackUnderflow(String[] inputValues) {
        int count = 0;
        for (int i = 0; i < inputValues.length; i++) {
            if (inputValues[i].equals("-")) {
                count--;
            } else {
                count++;
            }

            if (count < 0) return true;
        }

        return false;
    }

    public static boolean canPermutationBeGenerated(String[] inputValues) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;

        for (int i = 0; i < inputValues.length; i++) {
            int value = Integer.parseInt(inputValues[i]);

            if (stack.isEmpty() || value > stack.peek()) {
                while (current < value) {
                    stack.push(current);
                    current++;
                }

                current++;
            } else if (value == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }
}
