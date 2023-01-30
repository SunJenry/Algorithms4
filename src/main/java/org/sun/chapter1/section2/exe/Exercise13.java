package org.sun.chapter1.section2.exe;

import java.util.Date;
import java.util.Objects;

public class Exercise13 {
    public static void main(String[] args) {

    }

    public static class Transaction {
        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String getWho() {
            return who;
        }

        public Date getWhen() {
            return when;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Transaction{" + "who='" + who + '\'' + ", when=" + when + ", amount=" + amount + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Transaction)) return false;
            Transaction that = (Transaction) o;
            return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getWho(), that.getWho()) && Objects.equals(getWhen(), that.getWhen());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getWho(), getWhen(), getAmount());
        }
    }
}
