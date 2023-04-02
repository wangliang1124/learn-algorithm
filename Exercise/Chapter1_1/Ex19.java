package Exercise.Chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex19 {
    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
            // StdOut.println(N + " " + F(N));
            long[] cache = new long[N + 1];
            StdOut.println(N + " " + enhancedF1(N, cache));
            StdOut.println(N + " " + enhancedF2(N));
            StdOut.println("========================================");
        }
    }

    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return F(N - 1) + F(N - 2);
    }

    private static long enhancedF1(int n, long[] cachedValues) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (cachedValues[n] > 0) {
            return cachedValues[n];
        }

        cachedValues[n] = enhancedF1(n - 1, cachedValues) + enhancedF1(n - 2, cachedValues);

        return cachedValues[n];
    }

    private static long enhancedF2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long[] cachedValues = new long[n + 1];
        cachedValues[0] = 0;
        cachedValues[1] = 1;

        for (int i = 2; i <= n; i++) {
            cachedValues[i] = cachedValues[i - 2] + cachedValues[i - 1];
        }
        return cachedValues[n];
    }
}
