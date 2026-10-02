class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        //find the k number starting from end of the bucket
        for (int i = nums.length; i > 0 ; --i) {
            if (bucket[i] == null) {
                continue;
            }
            for (int n : bucket[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }

        return new int[]{};
    }
}
