class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        Arrays.fill(out, 1);

        int leftProduct = 1;
        for (int i = 0; i < nums.length; ++i) {
            out[i] = out[i] * leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            out[i] = out[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return out;
    }
}  
