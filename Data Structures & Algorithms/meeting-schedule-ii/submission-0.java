/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // 1. Sort intervals by start time in ascending order
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        // 2. Min-heap to store the end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 3. Iterate through all intervals
        for (Interval current : intervals) {
            // If the earliest ending meeting finishes at or before the current start, reuse
            // the room
            if (!minHeap.isEmpty() && current.start >= minHeap.peek()) {
                minHeap.poll();
            }
            // Allocate room for the current meeting
            minHeap.offer(current.end);
        }

        // 4. The size of the heap is the minimum number of rooms needed
        return minHeap.size();
    }
}
