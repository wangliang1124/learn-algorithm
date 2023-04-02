package Exercise.Chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex24 {
    public static void main(String[] args) {
        int p = 105;
        int q = 24;
        int gcd = gcd(p, q, 0);
        StdOut.printf("gcd = %d\n", gcd);

        p = 1111111;
        q = 1234567;
        // p = 6;
        // q = 9;
        gcd = gcd(p, q, 0);
        StdOut.printf("gcd = %d\n", gcd);
    }

    public static int gcd(int p, int q, int recurLevel) {
        if (p < 0 || q < 0) {
            throw new IllegalArgumentException("p and q must be non-negative");
        }

        printIntent(recurLevel);
        StdOut.printf("p = %d, q = %d\n", p, q);
        if (q == 0) {
            return p;
        }

        int r = p % q;
        return gcd(q, r, recurLevel + 1);
    }

    private static void printIntent(int n) {
        StdOut.printf("level %d: ", n);
        for (int i = 0; i < n; i++) {
            StdOut.print("--");
        }
    }
}
