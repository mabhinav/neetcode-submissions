class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'T';
                queue.offer(new int[]{i, 0});
            }

            if (board[i][n-1] == 'O') {
                board[i][n-1] = 'T';
                queue.offer(new int[]{i, n-1});
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'T';
                queue.offer(new int[]{0, j});
            }

            if (board[m-1][j] == 'O') {
                board[m-1][j] = 'T';
                queue.offer(new int[]{m-1, j});
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] dir : dirs) {
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || board[nr][nc] != 'O') {
                    continue;
                }
                board[nr][nc] = 'T';
                queue.offer(new int[]{nr, nc});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
