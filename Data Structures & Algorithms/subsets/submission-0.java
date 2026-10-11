class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, 
            List<Integer> currList, 
            List<List<Integer>> res) {

        res.add(new ArrayList<>(currList));

        for (int i = start; i < nums.length; i++) {
            currList.add(nums[i]);
            backtrack(i + 1, nums, currList, res);
            currList.remove(currList.size() - 1);
        }
    }
}
