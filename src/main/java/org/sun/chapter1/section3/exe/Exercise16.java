package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Queue;
import org.sun.util.Date;
import org.sun.util.In;
import org.sun.util.StdOut;

public class Exercise16 {

    public static void main(String[] args) {
        String dateFilePath = args[0];
        Date[] dates = readAllDates(dateFilePath);

        for (Date date : dates) {
            StdOut.println(date);
        }
    }

    private static Date[] readAllDates(String fileName) {
        In in = new In(fileName);
        Queue<Date> queue = new Queue<>();

        while (!in.isEmpty()) {
            queue.enqueue(new Date(in.readString()));
        }

        int n = queue.size();
        Date[] dates = new Date[n];

        for (int i = 0; i < n; i++) {
            dates[i] = queue.dequeue();
        }

        return dates;
    }
}
