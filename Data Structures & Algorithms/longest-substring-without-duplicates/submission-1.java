class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                while(set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    ++left;
                }
            } else {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, (right - left + 1));
                ++right;
            }
        }

        return maxLen;
    }
}
