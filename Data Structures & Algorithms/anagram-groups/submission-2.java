class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            Arrays.fill(count, 0);

            for (int i = 0; i < str.length(); ++i) {
                ++count[str.charAt(i) - 'a'];
            }

            sb.setLength(0);
            for (int i = 0; i < 26; ++i) {
                sb.append("#").append(count[i]);
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
