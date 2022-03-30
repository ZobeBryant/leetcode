package 动态规划.背包问题.零一背包.最后一块石头的重量;

public class Solution {
    // 目标：正数集合和负数集合的差尽可能的小 => 负数集合的总和尽可能的接近 sum / 2;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int s: stones){
            sum += s;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][ target + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j <= target; ++j ){
                if(stones[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
                }
            }
        }
        for(int j = target;  j >= 0; --j){
            if(dp[n][j]){
                return sum - 2 * j;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] a = {2,7,4,1,8,1};
        sl.lastStoneWeightII(a);
    }
}
