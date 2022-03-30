package HOT100.买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        // 表示当天出售股票的最大利润
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int max = 0;
        for(int i = 1; i < prices.length; ++i){
            dp[i] = Math.max(prices[i] - prices[i - 1], dp[i - 1] + prices[i] - prices[i -1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
