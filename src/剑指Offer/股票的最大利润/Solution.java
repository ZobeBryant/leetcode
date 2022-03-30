package 剑指Offer.股票的最大利润;

public class Solution {

    // 动态规划 dp[i]表示第i+1天卖出股票的最大利润
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        int maxProfit = 0;
        for(int i = 1; i < n; ++i){
            dp[i] = Math.max(0, Math.max(dp[i-1] + prices[i] - prices[i-1], prices[i] - prices[i-1]));
            if(dp[i] > maxProfit)
                maxProfit = dp[i];
        }
        return maxProfit;
    }


}
