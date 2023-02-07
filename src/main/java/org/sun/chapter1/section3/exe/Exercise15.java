package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Queue;
import org.sun.util.StdOut;

public class Exercise15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        String input = args[1];
        String[] stringsInput = input.split("\\s");

        Queue<String> strings = new Queue<>();

        for (int i = 0; i < stringsInput.length; i++) {
            strings.enqueue(stringsInput[i]);
        }

        int targetIndex = strings.size() - k;

        int index = 0;

        for (String ele : strings) {
            if (index == targetIndex) {
                StdOut.println(ele);
            }

            index++;
        }
    }
}
