class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxFrequency = 0;
        int left = 0;
        int n = s.length();

        for (int right = 0; right < n; ++right) {
            maxFrequency = Math.max(maxFrequency, ++counts[s.charAt(right) - 'A']);

            // if number of chars to replace exceed k
            // shift the window by 1 position
            // window Size = right - left + 1
            // maxFrequncy is no of repeating characters
            // check if difference is more than allowed k swaps
            // shift the window
            if ((right - left + 1) - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                ++left;
            }
        }

        return n - left;
    }
}
