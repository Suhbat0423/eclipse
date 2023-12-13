import java.util.Stack;

public class Lab3_2 {

    public static void main(String[] args) {
        String exp = "20+34*44-6/3*5+9"; 
        String pfexp = infixToPostfix(exp);
        System.out.println(pfexp);
        System.out.println("Ur nun: " + PostfixBodoh(pfexp));
    }

    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                int operand = 0;
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    operand = operand * 10 + (infix.charAt(i) - '0');
                    i++;
                }
                i--;
                postfix.append(operand).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Pop '(' from the stack
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    static int PostfixBodoh(String exp) {
        MyStack ms = new MyStack();

        String[] tokens = exp.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                ms.push(Integer.parseInt(token));
            } else {
                int val1 = (int) ms.pop();
                int val2 = (int) ms.pop();

                switch (token) {
                    case "+":
                        ms.push(val2 + val1);
                        break;

                    case "-":
                        ms.push(val2 - val1);
                        break;

                    case "/":
                        ms.push(val2 / val1);
                        break;

                    case "*":
                        ms.push(val2 * val1);
                        break;
                }
            }
        }
        return (int) ms.pop();
    }

    static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}
