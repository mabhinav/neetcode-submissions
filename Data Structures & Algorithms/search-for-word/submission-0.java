class Solution {
    public boolean exist(char[][] board, String word) {
        int[] freq = new int[58];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                freq[board[i][j] - 'A']++;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (--freq[word.charAt(i) - 'A'] < 0) {
                return false;
            }
        }

        int countFirstChar = count(board, word.charAt(0));
        int countLastChar = count(board, word.charAt(word.length() - 1));

        if (countFirstChar > countLastChar) {
            word = new StringBuilder(word).reverse().toString();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
            || board[r][c] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        board[r][c] = ' ';
        boolean found = dfs(board, word, idx + 1, r + 1, c) || dfs(board, word, idx + 1, r - 1, c)
            || dfs(board, word, idx + 1, r, c + 1) || dfs(board, word, idx + 1, r, c - 1);

        board[r][c] = word.charAt(idx);
        return found;
    }

    private int count(char[][] board, char target) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target) {
                    count++;
                }
            }
        }

        return count;
    }
}
