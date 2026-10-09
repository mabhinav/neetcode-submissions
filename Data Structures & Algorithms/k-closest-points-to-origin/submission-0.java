class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((idx1, idx2) -> {
            int dist1 = (points[idx1][0] * points[idx1][0]) + (points[idx1][1] * points[idx1][1]);
            int dist2 = (points[idx2][0] * points[idx2][0]) + (points[idx2][1] * points[idx2][1]);
            return Integer.compare(dist1, dist2);
        });

        for (int i = 0; i < points.length; i++) {
            minHeap.offer(i);
        }

        int index = 0;
        while(index < k) {
            int minIndex = minHeap.poll();
            result[index][0] = points[minIndex][0];
            result[index][1] = points[minIndex][1];
            ++index;
        }

        return result;
    }
}
