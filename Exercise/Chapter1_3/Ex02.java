package Exercise.Chapter1_3;

import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class Ex02 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String[] a = "it was - the best - of times - - - it was - the - -".split("\\s+");
        // String[] a = "times - - - it".split("\\s+");
        StdOut.println(a.length);

        // while (!StdIn.isEmpty()) {
        // String s = StdIn.readString();
        // if (s.equals("-") && !stack.isEmpty()) {
        // StdOut.println(stack.pop());
        // } else {
        // stack.push(s);
        // }
        // }

        for (String s : a) {
            if (s.equals("-") && !stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            } else {
                stack.push(s);
            }
        }

        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
