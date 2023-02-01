package org.sun.chapter1.section3.exe;

import org.sun.util.StdOut;

import java.util.Objects;
import java.util.Stack;

public class Exercise9 {
    public static void main(String[] args) {
        String infixExpression = getInfixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        String s = "((1+2)*((3-4)*(5-6))";
        StdOut.println(infixExpression);
    }

    public static String getInfixExpression(String expression) {

        String[] split = expression.split("\\s");

        Stack<String> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        for (String ele : split) {
            if (ele.equals("+") || ele.equals("-") || ele.equals("*") || ele.equals("/")) {
                operators.push(ele);
            } else if (ele.equals(")")) {
                String operand = operands.pop();
                String operand1 = operands.pop();
                String operator = operators.pop();

                String s = "(" + operand1 + operator + operand + ")";
                operands.push(s);
            } else {
                operands.push(ele);
            }
        }

        return operands.pop();
    }
}
