package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex11 {
    public static void main(String[] args) {
        String expr = "4 2 + 1 3 - *";//
        double result1 = evlautePostFix(expr);
        double result2 = evlautePostFix("5 3 4 * + 2 3 * - 3 / 1 3 + + ");
        double result3 = evlautePostFix(
                "1     2   +   3     6 * +       4     2   /   *   5     2   * -   8     2   / +     9 - ");

        StdOut.printf("result1 = %.2f\n", result1);
        StdOut.printf("result2 = %.2f\n", result2);
        StdOut.printf("result3 = %.2f\n", result3);
    }

    public static double evlautePostFix(String postfixExpression) {
        Stack<Double> operands = new Stack<>();
        String[] values = postfixExpression.split("\\s+");
        for (String value : values) {
            if (value.equals("+")
                    || value.equals("-")
                    || value.equals("*")
                    || value.equals("/")) {
                double op2 = operands.pop();
                double op1 = operands.pop();
                if (value.equals("+")) {
                    operands.push(op1 + op2);
                }
                if (value.equals("-")) {
                    operands.push(op1 - op2);
                }
                if (value.equals("*")) {
                    operands.push(op1 * op2);
                }
                if (value.equals("/")) {
                    operands.push(op1 / op2);
                }
            } else {
                operands.push(Double.valueOf(value));
            }
        }

        return operands.pop();
    }
}
