package Exercise.Chapter1_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

public class Ex09 {
    public static void main(String[] args) {
        int[] arr = { 2, 10, 3, 6, 5, 4, 7, 1, 9, 8 };
        int[] keys = { 10, 12, 5 };

        Counter counter = new Counter("operations");
        Arrays.sort(arr);
        for (int key : keys) {
            if (rank(key, arr, counter) == -1)
                StdOut.println(key);
            ;
        }

        StdOut.println(counter);
    }

    static int rank(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            counter.increment();
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
