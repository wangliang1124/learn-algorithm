package Exercise.Chapter1_1;

class Ex05 {

    public static void main(String[] args) {
        isStrictlyBetween0And1(1.12, 1.33);

        isStrictlyBetween0And1(0.5, 0.75);
    }

    static void isStrictlyBetween0And1(double x, double y) {
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
