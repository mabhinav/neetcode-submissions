class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while(!maxHeap.isEmpty() && maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();

            int w = Math.abs(s1 - s2);

            if (w != 0) {
                maxHeap.offer(w);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
