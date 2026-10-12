class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        //precompute the palindrome table
        boolean[][] pal = new boolean[n][n];

        for (int i = n - 1; i >=0 ; i--) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])) {
                        pal[i][j] = true;
                    }
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(s, pal, new ArrayList<>(), 0, result);
        return result;
    }

    private void backtrack(String s, boolean[][] pal, List<String> cur, int start, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!pal[start][end]) continue;

            cur.add(s.substring(start, end+1));
            backtrack(s, pal, cur, end + 1, res);
            cur.remove(cur.size() - 1);
        }
    }

}
