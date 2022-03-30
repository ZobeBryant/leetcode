package 动态规划.买卖股票的最佳时机含手续费;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 两种状态 dp[i][0] 表示持有累计最大收益 dp[i][1]表示不持有累计最大收益
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + prices[i] - fee);
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
