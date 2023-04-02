package Exercise.Chapter1_1;

public class Ex10 {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(ln(N));

        double check = 0.0;
        for (int i = 1; i <= N; i++) {
            check += Math.log(i);
        }
        System.out.println(check);
    }

    private static double ln(int n) {
        if (n == 1)
            return 0;

        return Math.log(n) + ln(n - 1);
    }
}
