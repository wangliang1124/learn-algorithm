package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex16 {
    public static void main(String[] args) {
        Date[] dates = readAllDates(args[0]);

        for (Date date : dates) {
            StdOut.println(date);
        }
    }

    public static Date[] readAllDates(String fileName) {
        In in = new In(fileName);
        Queue<Date> queue = new Queue<>();

        while (!in.isEmpty()) {
            String str = in.readString();
            System.out.println("date: " + str);
            queue.enqueue(new Date(str));
        }

        int n = queue.size();
        Date[] dates = new Date[n];
        for (int i = 0; i < n; i++) {
            dates[i] = queue.dequeue();
        }

        return dates;
    }
}
