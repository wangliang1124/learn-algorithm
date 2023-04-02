package Exercise.Chapter1_1;

public class Ex09 {

  public static void main(String[] args) {
    int N = 9;
    System.out.println(Integer.toBinaryString(N));

    String s = "";
    for (int i = N; i > 0; i /= 2) {
      System.out.println(i);
      s = i % 2 + s;
    }

    System.out.println(s);

    int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = i * i;
    }
    System.out.println(a);
  }
}
