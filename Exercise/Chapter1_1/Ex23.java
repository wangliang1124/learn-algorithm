package Exercise.Chapter1_1;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import Exercise.Chapter1_1.Ex22;

public class Ex23 {
    // java Ex23 tinyW.txt - < tinyT.txt
    // java Ex23 tinyW.txt + < tinyT.txt
    public static void main(String[] args) {

        int[] whitelist = new In(args[0]).readAllInts();
        String op = args[1];
        System.out.println(op);
        if (!op.equals("-") && !op.equals("+")) {
            throw new IllegalArgumentException("Operation needs to be - or +");
        }

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = Ex22.rank(whitelist, key);
            System.out.println();
            System.out.println("Input key:" + key);
            if (index > 0 && op.equals("-")) {
                StdOut.println("Number in whitelist: " + key);
            } else if (index == -1 && op.equals("+")) {
                StdOut.println("Number not in whitelist: " + key);
            }
        }
    }
}
