class Solution {
    private static final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
       if (digits == null || digits.length() == 0) {
        return res;
       }
       backtrack(digits, new StringBuilder(), 0, res);
       return res; 
    }

    private void backtrack(String digits, StringBuilder cur, int idx, List<String> res) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }

        String letters = MAP[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            cur.append(letters.charAt(i));
            backtrack(digits, cur, idx + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
