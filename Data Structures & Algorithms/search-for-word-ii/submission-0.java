class Solution {
    private static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        int childCount;
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (cur.childrens[idx] == null) {
                    cur.childrens[idx] = new TrieNode();
                    cur.childCount++;
                }
                cur = cur.childrens[idx];
            }
            cur.word = word;
        }

        List<String> res = new ArrayList<>();
        
        int rows = board.length;
        int cols = board[0].length;

        // iterate the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, rows, cols, r, c, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, final int ROWS, final int COLS, int r, int c, TrieNode node, List<String> res) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        TrieNode next = node.childrens[ch - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {
            res.add(next.word);
            next.word = null;

            if (next.childCount == 0) {
                node.childrens[ch - 'a'] = null;
                --node.childCount;
                return;
            }
        }

        // mark the cell as visited
        board[r][c] = '#';
        dfs(board, ROWS, COLS, r - 1, c, next, res);
        dfs(board, ROWS, COLS, r + 1, c, next, res);
        dfs(board, ROWS, COLS, r, c - 1, next, res);
        dfs(board, ROWS, COLS, r, c + 1, next, res);

        board[r][c] = ch;

        if (next.childCount == 0) {
            node.childrens[ch - 'a'] = null;
            --node.childCount;
        }
    }
}
