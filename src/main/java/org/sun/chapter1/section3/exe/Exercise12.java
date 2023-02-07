package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Stack;

public class Exercise12 {
    public static void main(String[] args) {

    }

    public static Stack<String> copyStack(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        Stack<String> result = new Stack<>();

        for (String ele : stack) {
            temp.push(ele);
        }

        for (String ele : temp) {
            result.push(ele);
        }

        return result;
    }
}
