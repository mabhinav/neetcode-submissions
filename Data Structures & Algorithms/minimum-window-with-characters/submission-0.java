class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];

        for (char ch : t.toCharArray()) {
            ++count[ch];
        }

        int left = 0;
        int required = t.length();
        int minLen = 100001;
        int start = 0;

        for (int right = 0; right < s.length(); ++right) {
            char rc = s.charAt(right);

            if (count[rc] > 0) {
                required--;
            }
            --count[rc];
            while (required == 0) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left);
                count[lc]++;

                if (count[lc] > 0) {
                    required++;
                }
                left++;
            }
        }
        
        return minLen == 100001 ? "" : s.substring(start, start + minLen);
    }
}
