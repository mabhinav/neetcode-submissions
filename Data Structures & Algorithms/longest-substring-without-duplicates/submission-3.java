class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[255];
        int maxLen = 0;
        
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            left = Math.max(left, lastSeen[ch]);
            maxLen = Math.max(maxLen, (right - left + 1));
            lastSeen[ch] = right + 1;
        }

        return maxLen;
    }
}
