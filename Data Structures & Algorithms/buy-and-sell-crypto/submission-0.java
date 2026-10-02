class Solution {
    public int maxProfit(int[] prices) {
        // Can not sell before I buy - no short selling
        // goal - buy at lowest price and sell at max price in fture

        int minBuyPrice = prices[0];
        int i = 1;
        int maxProfit = 0;

        while (i < prices.length) {
            int profit = prices[i] - minBuyPrice;
            maxProfit = Math.max(maxProfit, profit);
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }
            ++i;
        }

        return maxProfit;
    }
}
