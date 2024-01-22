package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class Ex17 {
    public static void main(String[] args) {
        String transactionFilePath = args[0];
        Transaction[] transactions = readAllTransactions(transactionFilePath);

        for (Transaction transaction : transactions) {
            StdOut.println(transaction);
        }
    }

    public static Transaction[] readAllTransactions(String fileName) {
        In in = new In(fileName);
        Queue<Transaction> queue = new Queue<>();

        while (!in.isEmpty()) {
            String str = in.readLine();
            System.out.println("transaction: " + str);
            queue.enqueue(new Transaction(str));
        }

        int size = queue.size();
        Transaction[] transactions = new Transaction[size];

        for (int i = 0; i < size; i++) {
            transactions[i] = queue.dequeue();
        }

        return transactions;
    }
}
