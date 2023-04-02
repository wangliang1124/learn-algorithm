package Exercise.Chapter1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex15 {

    public static void main(String[] args) {
        // int[] a = { 1, 1, 2, 3, 3, 4, 1, 5, 2, 7, 9 };
        int N = 100;
        int M = 50;
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(M);
            StdOut.printf("%s ", a[i]);
        }
        StdOut.println();
        int[] b = histogram(a, M);
        for (int i = 0; i < b.length; i++) {
            System.out.println("index:" + i + ",value:" + b[i]);
        }
    }

    static int[] histogram(int[] a, int M) {
        int[] ret = new int[M];
        for (int i = 0; i < a.length; i++) {
            ret[a[i]]++;
        }

        return ret;
    }
}
