class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch(token) {
                case "+", "-", "*", "/":
                    stack.push(apply(stack.pop(), stack.pop(), token));
                    break;
                default:
                    stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private String apply (String a, String b, String op) {
        int res = 0;
        switch(op) {
            case "+":
                res = Integer.parseInt(b) + Integer.parseInt(a);
                break;
            case "-":
                res = Integer.parseInt(b) - Integer.parseInt(a);
                break;
            case "*":
                res = Integer.parseInt(b) * Integer.parseInt(a);
                break;
            case "/":
                res = Integer.parseInt(b) / Integer.parseInt(a);
                break;
        }
        return String.valueOf(res);
    }
}
