class Solution {
    static Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }


        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || !(map.get(stack.pop()) == ch)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
