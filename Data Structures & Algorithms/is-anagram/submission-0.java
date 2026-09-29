class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null || count == 0) {
                return false;
            }
            map.merge(ch, -1, Integer::sum);
        }
        return true;
    }
}
