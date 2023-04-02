package Exercise.Chapter1_2;

import edu.princeton.cs.algs4.StdOut;

public class Ex06 {
    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        StdOut.println(isCircular(s, t));
        s = "123456789";
        t = "912345678";
        StdOut.println(isCircular(s, t));
        // true
        // true

        s = "1234567891";
        t = "912345678";
        StdOut.println(isCircular(s, t));
    }

    static boolean isCircular(String s, String t) {
        return s.length() == t.length() && (s + s).indexOf(t) != -1;
    }
}
