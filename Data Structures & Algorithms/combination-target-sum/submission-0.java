class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, 
                int target, 
                int start, 
                List<Integer> currList,
                List<List<Integer>> res) {
        
        if (target == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            currList.add(nums[i]);
            backtrack(nums, target - nums[i], i, currList, res);
            currList.remove(currList.size() - 1);
        }
    }
}
