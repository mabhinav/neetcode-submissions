class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        int first = 0, last = 0;
        for (int i = 0; i < nums.length; ++i) {
            int searchNum = target - nums[i];
            if (map.containsKey(searchNum) 
                && i != (last = map.get(searchNum))) {
                first = i;
                break;
            }
        }

        if (first > last) {
            return new int[]{last, first};
        }
        return new int[]{first, last};
    }
}
