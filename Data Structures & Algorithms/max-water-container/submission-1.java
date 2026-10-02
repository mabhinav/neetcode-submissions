class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        int width;
        int height;
        while (left < right) {
            width = right - left;
            height = Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, (width * height));

            if (heights[left] > heights[right]) {
                --right;
            } else {
                ++left;
            }
        }

        return maxWater;
    }
}
