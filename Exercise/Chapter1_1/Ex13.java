package Exercise.Chapter1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Ex13 {

    public static void main(String[] args) {
        int arr[][] = genRandomIntArr(5, 9);
        System.out.println("before transpose:");
        print(arr);
        int transposed[][] = transpose(arr);
        System.out.println("after transpose:");
        print(transposed);
    }

    public static int[][] genRandomIntArr(int M, int N) {
        int a[][] = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = StdRandom.uniform(0, 10);
            }
        }

        return a;
    }

    private static int[][] transpose(int[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        int[][] b = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                b[i][j] = arr[j][i];
            }
        }

        return b;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
