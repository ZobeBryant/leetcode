package 京东秋招.零钱兑换1;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        // 完全背包
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= coins.length; ++i){
            int coin = coins[i - 1];
            for(int j = 0; j <= amount; ++j){
                if(j >= coin){
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        Solution sl = new Solution();
        sl.coinChange(coins, 11);
    }
}
