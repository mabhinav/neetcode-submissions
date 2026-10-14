class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        
        for(int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[0];
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }
}
