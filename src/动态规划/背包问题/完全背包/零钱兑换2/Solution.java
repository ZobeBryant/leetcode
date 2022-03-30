package 动态规划.背包问题.完全背包.零钱兑换2;

public class Solution {

    public int change(int amount, int[] coins) {
        // 二维数组
        int n = coins.length;
        int[][] dp = new int[n+1][amount +1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; ++i){
            int coin = coins[i-1];
            for(int j = 0; j <= amount; ++j){
                dp[i][j] = dp[i - 1][j];
                if(j - coin >= 0) dp[i][j] += dp[i][j-coin];
            }
        }
        return dp[n][amount];
    }
    // 组合数
    public int change2(int amount, int[] coins) {
        // 一维数组 滚动数组
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 外循环：硬币种类
        for(int i = 0; i < n; ++i){
            int coin = coins[i];
            // 内循环：总价值
            for(int j = coin; j <= amount; ++j){
                // 要么不组合 要么组合
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}
