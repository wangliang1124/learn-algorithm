package Exercise.Chapter1_1;

public class Ex14 {

    public static void main(String[] args) {
        int number = 8;
        System.out.println(lg(number));

        int n = (int) (Math.log(number) / Math.log(2));
        System.out.println("log of " + number + "(base-2) is: " + n);
    }

    private static int lg(int N) {
        int ret = 0;
        while (N > 0) {
            // N /= 2;
            N >>= 1;
            ret++;
        }

        return ret - 1;
    }
}
