class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCountArray = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++charCountArray[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < t.length(); ++i) {
            int index = t.charAt(i) - 97;
            --charCountArray[index];
            if (charCountArray[index] < 0) {
                return false;
            }
        }

        return true;
    }
}
