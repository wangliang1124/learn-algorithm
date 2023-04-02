package Exercise.Chapter1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
// Parameters example:
// Rene 2 1
// Bacon 4 3
// Abcdef 6 2

public class Ex21 {
    public static void main(String[] args) {

        In in = new In();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] values = line.split(" ");

            String name = values[0];
            String num1 = values[1];
            String num2 = values[2];
            double result = Double.parseDouble(num1) / Double.parseDouble(num2);

            System.out.printf("%8s%8s%8s%7.3f", name, num1, num2, result);
            System.out.print(" => ");
        }
        // while (!StdIn.isEmpty()) {
        // String name = StdIn.readString();
        // int num1 = StdIn.readInt();
        // int num2 = StdIn.readInt();
        // double result = num1 / num2;

        // System.out.printf("%8s%8s%8s%7.3f", name, num1, num2, result);
        // System.out.print(" => ");
        // }
    }
}
