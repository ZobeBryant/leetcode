package 动态规划.使用最小花费爬楼梯;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] 表示到达阶梯i的花费
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
