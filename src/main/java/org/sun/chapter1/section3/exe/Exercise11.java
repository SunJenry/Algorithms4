package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Stack;
import org.sun.util.StdOut;

public class Exercise11 {
    public static void main(String[] args) {
        String s = Exercise10.infixToPostfix("( ( 1 + 2 ) * ( 4 / 2 ) )");
        double v = evaluatePostfix(s);
        StdOut.println(v);
    }

    public static double evaluatePostfix(String expression) {
        String[] split = expression.split("\\s");
        Stack<Double> result = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];


            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                Double pop = result.pop();
                Double pop1 = result.pop();

                double temp;
                if (s.equals("+")) {
                    temp = pop1 + pop;
                } else if (s.equals("-")) {
                    temp = pop1 - pop;
                } else if (s.equals("*")) {
                    temp = pop1 * pop;
                } else {
                    temp = pop1 / pop;
                }

                result.push(temp);
            } else {
                result.push(Double.parseDouble(s));
            }
        }

        return result.pop();
    }

}
