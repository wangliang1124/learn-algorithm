package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex12 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("First Item");
        stack.push("Second Item");
        stack.push("Third Item");

        Stack<String> copy = copy(stack);
        stack.pop();
        stack.pop();

        StdOut.println(" ===== copyed stack ====");
        for (String s : copy) {
            StdOut.println(s);
        }
        StdOut.println(" ===== origin stack ====");
        for (String s : stack) {
            StdOut.println(s);
        }

    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        Stack<String> copy = new Stack<>();

        for (String item : stack) {
            temp.push(item);
        }

        for (String item : temp) {
            copy.push(item);
        }

        return copy;
    }
}
