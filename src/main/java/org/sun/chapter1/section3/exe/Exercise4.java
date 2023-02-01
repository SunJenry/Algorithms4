package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Stack;
import org.sun.util.StdOut;

public class Exercise4 {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        String s1 = "[(])";
        String s2 = "[()";
        StdOut.println(s + " is balance:" + isParenthesesBalanced(s));
        StdOut.println(s1 + " is balance:" + isParenthesesBalanced(s1));
        StdOut.println(s2 + " is balance:" + isParenthesesBalanced(s2));
    }

    public static boolean isParenthesesBalanced(String parentheses) {
        char[] chars = parentheses.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (Character element : chars) {
            if (element == '(' || element == '[' || element == '{') {
                stack.push(element);
            } else {
                Character pop = stack.pop();
                if (element == ')') {
                    if (pop != '(') {
                        return false;
                    }
                } else if (element == ']') {
                    if (pop != '[') {
                        return false;
                    }
                } else if (element == '}') {
                    if (pop != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
