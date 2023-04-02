package Exercise.Chapter1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Ex11 {

    public static void main(String[] args) {
        boolean[][] array = genBooleanArr(6, 9); // { { true, false, true }, { false, false, true } };
        printArray(array);
    }

    public static boolean[][] genBooleanArr(int M, int N) {
        boolean[][] a = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = StdRandom.bernoulli();
            }
        }

        return a;
    }

    private static void printArray(boolean[][] array) {
        System.out.print(" ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.printf("%2d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j])
                    System.out.printf("%2s", "*");
                else
                    System.out.printf(
                            "%2s",
                            "-");
            }
            System.out.println();
        }
    }
}
