class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        int windowLength = s1.length();

        for (int i = 0; i < windowLength; ++i) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        for (int i = windowLength; i < s2.length(); ++i) {
            if (match(countS1, countS2)) {
                return true;
            }
            char ch = s2.charAt(i - windowLength);
            --countS2[ch - 'a'];
            ++countS2[s2.charAt(i) - 'a'];
        }
        return match(countS1, countS2);
    }

    private boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
