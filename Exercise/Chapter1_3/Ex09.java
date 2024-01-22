package Exercise.Chapter1_3;

import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class Ex09 {
    public static void main(String[] args) {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        StdOut.println(insertPrefix(input));
    }

    public static String insertPrefix(String input) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] inputValues = input.split("\\s");
        for (String value : inputValues) {
            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                operators.push(value);
            } else if (value.equals(")")) {
                String operator = operators.pop();
                String operand2 = operands.pop();
                String operand1 = operands.pop();

                String fixedString = "(" + operand1 + operator + operand2 + value;

                operands.push(fixedString);
            } else {
                operands.push(value);
            }
        }
        return operands.pop();
    }
}
