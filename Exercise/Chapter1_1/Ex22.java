package Exercise.Chapter1_1;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Ex22 {
    public static void main(String[] args) {
        int arr[] = ascInts(0, 100);
        int key = 51;
        Arrays.sort(arr);

        int index = rank(key, arr, 0, arr.length - 1, 0);

        StdOut.println();
        StdOut.println("Index: " + index);
    }

    public static int rank(int[] arr, int key) {
        return rank(key, arr, 0, arr.length - 1, 0);
    }

    private static int rank(int key, int[] arr, int lo, int hi, int depth) {
        if (depth > 0) {
            System.out.println();
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        StdOut.print("lo:" + lo + " - " + "hi:" + hi);

        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid])
            return rank(key, arr, lo, mid - 1, depth + 1);
        else if (key > arr[mid])
            return rank(key, arr, mid + 1, hi, depth + 1);
        else
            return mid;
    }

    public static int[] ascInts(int lo, int hi) {
        int length = hi - lo + 1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + lo;
        }
        return arr;
    }
}
