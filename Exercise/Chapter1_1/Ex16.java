package Exercise.Chapter1_1;

public class Ex16 {
    public static void main(String[] args) {
        System.out.println(exR1(6));

        // exR1(6): exR1(3) + 6 + exR1(4) + 6 = 0031136114200246
        // exR1(3): exR1(0) + 3 + exR1(1) + 3 = 003113
        // exR1(4): exR1(1) + 4 + exR1(2) + 4 = 11420024
        // exR1(2): 2 + exR1(0) + 2 = 2002
        // exR1(1): 1 + 1 = 11
        // exR1(0): 0 + 0 = 00
        // 00311361142246
    }

    public static String exR1(int n) {
        if (n < 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
