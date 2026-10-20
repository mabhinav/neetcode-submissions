class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        boolean[] inMST = new boolean[n];
        minDist[0] = 0;

        int cost = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            // pick the unvisited node with min connection cost
            for (int j = 0; j < n; j++) {
                if (!inMST[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            inMST[u] = true;
            cost += minDist[u];

            // update distances
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0])
                        + Math.abs(points[u][1] - points[v][1]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }

        return cost;
    }
}
