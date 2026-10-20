class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int t = 0; t < times.length; t++) {
            graph[times[t][0]].add(new int[]{times[t][1], times[t][2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currNode = curr[0];
            int currDistance = curr[1];

            if (currDistance > dist[currNode]) {
                continue;
            }

            for (int[] neighbor : graph[currNode]) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];

                int newDistance = currDistance + edgeWeight;
                if (newDistance < dist[nextNode]) {
                    dist[nextNode] = newDistance;
                    pq.offer(new int[]{nextNode, newDistance});
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }
}
