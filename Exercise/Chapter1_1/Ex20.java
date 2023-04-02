package Exercise.Chapter1_1;

public class Ex20 {
    public static void main(String[] args) {
        int N = 10;
        double ret = ln(N);
        System.out.println(ret);

        double check = 0.0;
        for (int i = 1; i <= N; i++) {
            check += Math.log(i);
        }
        System.out.println(check);
    }

    private static double ln(int N) {
        if (N == 1) {
            return 0;
        }

        return Math.log(N) + ln(N - 1);
    }
}
