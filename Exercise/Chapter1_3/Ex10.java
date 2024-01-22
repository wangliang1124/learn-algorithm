package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.Stack;

// 数据结构和算法（六）：前缀、中缀、后缀表达式 https://zhuanlan.zhihu.com/p/37467928
public class Ex10 {
    public static void main(String[] args) {
        String infixExpression = "( ( 1 + 2 ) * ( 4 / 2 ) )";
        System.out.println("Infix expression: " + infixExpression);
        System.out.println("Postfix expression: " + infixToPostfix2(infixExpression)); // 1 2 + 4 2 / *

        // InfixToSuffix in = new InfixToSuffix("( ( 1 + 2 ) * ( 4 / 2 ) )");
        // Stack<Character> output = in.doTrans();
        infixExpression = "(( 1 + 2 + 3 * 6) * ( 4 / 2 ) - 5 * 2 + 8 / 2 ) - 9"; // "9 - 5 * 2 + 8 - 1";//
        System.out.println("Postfix expression: " + infixToPostfix2(infixExpression));
    }

    public static String infixToPostfix2(String input) {
        Stack<Character> operators = new Stack<>();
        Stack<Character> operands = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            char prevOperator;
            // System.out.println("operands:" + operands);
            // System.out.println("operators:" + operators);
            switch (ch) {
                case '+':
                case '-':
                    while (!operators.isEmpty()) {
                        prevOperator = operators.pop();
                        if (prevOperator == '(') {
                            operators.push(prevOperator);
                            break;
                        }

                        operands.push(prevOperator);

                    }
                    operators.push(ch);
                    break;

                case '*':
                case '/':
                    while (!operators.isEmpty()) {
                        prevOperator = operators.pop();
                        if (prevOperator == '(') {
                            operators.push(prevOperator);
                            break;
                        }

                        if ((prevOperator == '+' || prevOperator == '-')) {
                            operators.push(prevOperator);
                            break;
                        } else {
                            operands.push(prevOperator);
                        }

                    }
                    operators.push(ch);
                    break;
                case '(':
                    operators.push(ch);
                    break;
                case ')':
                    while (!operators.isEmpty()) {
                        prevOperator = operators.pop();
                        if (prevOperator == '(') {
                            break;
                        } else {
                            operands.push(prevOperator);
                        }
                    }
                    break;
                default:
                    if (ch != '\0') {
                        operands.push(ch);
                    }
            }
        }

        while (!operators.isEmpty()) {
            operands.push(operators.pop());
        }

        // StringBuilder s = new StringBuilder();
        // while (!operands.isEmpty()) {
        // s.insert(0, operands.pop() + " ");
        // }

        Stack<Character> temp = new Stack<>();
        for (Character item : operands) {
            temp.push(item);
        }

        return temp.toString();
    }

    public static String infixToPostfix(String input) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] inputValues = input.split("\\s");

        for (String value : inputValues) {
            if (value.equals("(")) {
                // do nothing
            } else if (value.equals("+")
                    || value.equals("-")
                    || value.equals("*")
                    || value.equals("/")) {
                operators.push(value);
            } else if (value.equals(")")) {
                String operator = operators.pop();
                String operand2 = operands.pop();
                String operand1 = operands.pop();

                String newExpression = operand1 + " " + operand2 + " " + operator;
                operands.push(newExpression);
            } else {
                operands.push(value);
            }
        }

        String postfixExpression = operands.pop();

        return postfixExpression;
    }
}
