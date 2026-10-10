class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, m - 1, j, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        for (int[] dir :  dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) {
                continue;
            }

            //reverse flow condition
            if (heights[row][col] <= heights[nr][nc]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
