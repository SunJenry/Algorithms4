package org.sun.chapter1.section3;

import org.sun.util.StdIn;
import org.sun.util.StdOut;

public class Evaluate {
    public static void main(String[] args) {

        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

        String[] split = expression.split(" ");

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        int index = 0;

        while (index < split.length) {
            String s = split[index];
            index++;

            StdOut.println("read:" + s);

            if (s.equals("(")) {
                StdOut.println("( do nothing");
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                StdOut.println(s + " push to ops");
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                Double val = vals.pop();

                if (op.equals("+")) {
                    val = vals.pop() + val;
                } else if (op.equals("-")) {
                    val = vals.pop() - val;
                } else if (op.equals("*")) {
                    val = vals.pop() * val;
                } else if (op.equals("/")) {
                    val = vals.pop() / val;
                } else if (op.equals("sqrt")) {
                    val = Math.sqrt(val);
                }

                vals.push(val);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }

        StdOut.println("Result:" + vals.pop());
    }
}
