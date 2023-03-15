package org.sun.chapter2.section1.exe;

public class Exe21 {
    public static void main(String[] args) {

    }

    public class Transaction implements Comparable<Transaction> {

        private final double amount;

        public Transaction(double amount) {
            this.amount = amount;
        }

        @Override
        public int compareTo(Transaction o) {
            if (this.amount > o.amount) return +1;
            if (this.amount < o.amount) return -1;
            return 0;
        }
    }
}
