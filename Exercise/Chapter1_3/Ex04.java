package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex04 {
    public static void main(String[] args) {
        String textStreamInput = StdIn.readString(); // [()]
        StdOut.println("Is balanced " + textStreamInput + ": " + isParenthesesBalanced(textStreamInput)
                + " Expected: true");

        StdOut.println("Is balanced [()]{}{[()()]()}: " + isParenthesesBalanced("[()]{}{[()()]()}")
                + " Expected: true");
        StdOut.println("Is balanced [(]): " + isParenthesesBalanced("[(])") + " Expected: false");
        StdOut.println("Is balanced [(): " + isParenthesesBalanced("[()") + " Expected: false");
    }

    public static boolean isParenthesesBalanced(String input) {
        char parentheses[] = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses) {
            if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
                stack.push(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char ch = stack.pop();
                if (parenthesis == ')' && ch != '(' || parenthesis == ']' && ch != '['
                        || parenthesis == '}' && ch != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
