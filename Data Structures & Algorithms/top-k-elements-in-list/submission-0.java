class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.merge(n, 1, Integer::sum);
        }

        List<Integer>[] list = (List<Integer>[]) new List<?>[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            if (list[count] == null) {
                list[count] = new ArrayList<>();
            }
            list[count].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0; --i) {
            if (list[i] == null) {
                continue;
            }
            for (int n : list[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
