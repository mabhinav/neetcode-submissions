class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        // add all treasures to the queue
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];

                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 2147483647) {
                    continue;
                }

                grid[r][c] = grid[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
