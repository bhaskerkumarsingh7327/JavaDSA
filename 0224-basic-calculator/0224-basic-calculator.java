
class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;

                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }
        }

        result += sign * number;

        return result;
    }
}
