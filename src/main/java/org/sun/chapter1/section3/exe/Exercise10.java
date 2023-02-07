package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Stack;
import org.sun.util.StdOut;

public class Exercise10 {
    public static void main(String[] args) {
        String infixToPostfix = infixToPostfix("( ( 1 + 2 ) * ( 4 / 2 ) )");
        StdOut.println(infixToPostfix);
    }

    public static String infixToPostfix(String expression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] split = expression.split("\\s");

        for (int i = 0; i < split.length; i++) {
            String ele = split[i];
            if (ele.equals("(")) {
                //do nothing
            } else if (ele.equals("+") || ele.equals("-") || ele.equals("*") || ele.equals("/")) {
                operators.push(ele);
            } else if (ele.equals(")")) {
                String pop = operands.pop();
                String pop1 = operands.pop();

                String operator = operators.pop();

                String newEle = pop1 + " " + pop + " " + operator;
                operands.push(newEle);
            } else {
                operands.push(ele);
            }
        }

        return operands.pop();
    }
}
