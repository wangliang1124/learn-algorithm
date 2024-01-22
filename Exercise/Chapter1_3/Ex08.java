package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex08 {
    public static void main(String[] args) {
        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        // it was - the best - of times - - - it was - the - -
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                if (!stack.isEmpty()) {
                    StdOut.println(stack.pop());
                }
            } else {
                stack.push(item);
            }
        }

        StdOut.printf("%d left on stack\n", stack.size());
        StdOut.printf("%d array capacity", stack.capacity());
    }

    static class DoublingStackOfStrings { // implements Iterable<String>
        private String[] a = new String[1];
        private int N = 0;

        public void push(String item) {
            if (isFull()) {
                resize(2 * a.length);
            }
            a[N++] = item;
        }

        public String pop() {
            String item = a[--N];
            a[N] = null;
            if (N == a.length / 4) {
                resize(a.length / 2);
            }
            return item;
        }

        public int size() {
            return N;
        }

        public int capacity() {
            return a.length;
        }

        public boolean isFull() {
            return N == a.length;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        private void resize(int cap) {
            System.out.println("-resize-");
            String[] temp = new String[cap];
            for (int i = 0; i < N; i++) {
                temp[i] = a[i];
            }

            a = temp;
        }
    }
}
