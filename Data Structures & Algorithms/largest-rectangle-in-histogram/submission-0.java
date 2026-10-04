class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <=n ; ++i) {
            int currHeight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }

            stack.push(i);
        }
        return maxArea;
    }
}