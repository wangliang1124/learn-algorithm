package Exercise.Chapter1_2;

import Exercise.Chapter1_2.Ex11.SmartDate;
import edu.princeton.cs.algs4.StdOut;

public class Ex13 {
    public static void main(String[] args) {
        SmartDate date = new SmartDate(8, 3, 2023);

        Transaction transaction = new Transaction("Rene", date, 500.0);
        StdOut.println(transaction);
        StdOut.println("Expected: Rene spent 500.0 on 8/3/2023");

        Transaction t1 = new Transaction("Liang", date, 100.12);
        Transaction t2 = new Transaction("Liang", new SmartDate(8, 3, 2023), 100.12);
        StdOut.println(t1.equals(t2));
    }

    static class Transaction {
        private String who;
        private SmartDate when;
        private double amount;

        Transaction(String who, SmartDate when, Double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String toString() {
            return who + " spent " + amount + " on " + when;
        }

        public boolean equals(Object x) {
            if (this == x)
                return true;

            if (x == null)
                return false;

            if (this.getClass() != x.getClass())
                return false;

            Transaction that = (Transaction) x;
            if (!this.who.equals(that.who))
                return false;
            if (!this.when.toString().equals(that.when.toString()))
                return false;
            if (this.amount != that.amount)
                return false;
            return true;
        }
    }
}
