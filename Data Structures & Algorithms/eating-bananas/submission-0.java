class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int hoursNeeded = 0;
            for (int pile : piles) {
                //hoursNeeded += (int) Math.ceil((double)pile / mid);
                hoursNeeded += (pile + mid - 1) / mid;
            }

            if (hoursNeeded <= h) {
                right = mid; // slow down the speed
            } else {
                left = mid + 1; // increase the speed
            }
        }

        return left;
    }
}
