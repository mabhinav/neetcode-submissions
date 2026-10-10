class Solution {
    public int orangesRotting(int[][] grid) {
        int countFresh = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        // get all rotten orange positions in queue
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    ++countFresh;
                }
            }
        }

        if (countFresh == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && countFresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];

                    if (r < 0 || r >= grid.length
                        || c < 0 || c >= grid[0].length 
                        || grid[r][c] != 1) {
                        continue;
                    }
                    
                    grid[r][c] = 2;
                    --countFresh;
                    queue.offer(new int[]{r, c});
                }
            }
            minutes++;
        }

        return countFresh == 0 ? minutes : -1;
    }
}
