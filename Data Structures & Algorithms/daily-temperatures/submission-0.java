class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] out = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                out[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            out[stack.pop()] = 0;
        }

        return out;
    }
}
