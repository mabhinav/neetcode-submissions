class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //-1,0,1,2,-1,-4
        //-4,-1,-1,0,1,2

        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] > 0) {
            return new ArrayList<>();
        }

        int n = nums.length;
        if (nums[n-1] + nums[n-2] + nums[n-3] < 0) {
            return new ArrayList<>();
        }

        int left;
        int right;
        int sum;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
               continue;
            }

            left = i + 1;
            right = n - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));

                    // ignore all values which are same as left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                      ++left;
                    }

                    // ignore all values which are same as right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }

                    // shrink the window
                    ++left;
                    --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return res;
    }
}
