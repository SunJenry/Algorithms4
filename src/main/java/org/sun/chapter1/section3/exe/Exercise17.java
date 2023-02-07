package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section2.exe.Exercise13;
import org.sun.chapter1.section3.Queue;
import org.sun.util.In;
import org.sun.util.StdOut;

public class Exercise17 {
    public static void main(String[] args) {
        String transactionFilePath = args[0];
        Exercise13.Transaction[] transactions = readAllTransactions(transactionFilePath);

        for (Exercise13.Transaction transaction : transactions) {
            StdOut.println(transaction);
        }
    }

    public static Exercise13.Transaction[] readAllTransactions(String fileName) {
        In in = new In(fileName);
        Queue<Exercise13.Transaction> queue = new Queue<>();

        while (!in.isEmpty()) {
            queue.enqueue(new Exercise13.Transaction(in.readLine()));
        }

        int queueSize = queue.size();
        Exercise13.Transaction[] transactions = new Exercise13.Transaction[queueSize];

        for (int i = 0; i < queueSize; i++) {
            transactions[i] = queue.dequeue();
        }

        return transactions;
    }
}
