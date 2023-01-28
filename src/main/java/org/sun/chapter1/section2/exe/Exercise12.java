package org.sun.chapter1.section2.exe;

import org.sun.util.StdOut;

public class Exercise12 {
    public static void main(String[] args) {
        Exercise11.SmartDate smartDate = new Exercise11.SmartDate(11, 3, 2001);
        String s = smartDate.dayOfTheWeek();
        StdOut.println(s);
    }
}
