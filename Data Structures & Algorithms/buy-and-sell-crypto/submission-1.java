class Solution {
    public int maxProfit(int[] prices) {
        // Can not sell before I buy - no short selling
        // goal - buy at lowest price and sell at max price in fture

        int minBuyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
            }
        }

        return maxProfit;
    }
}
