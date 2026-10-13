class Solution {
    private List<List<String>> res;
    private boolean[] cols;
    private boolean[] diag1; // r - c + n - 1
    private boolean[] diag2; // r + c
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        cols = new boolean[n];
        diag1 = new boolean[2*n - 1];
        diag2 = new boolean[2*n - 1];

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, n);

        return res;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            res.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            board[row][col] = 'Q';
            backtrack(row + 1, n);

            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
