package 京东秋招.零钱兑换2;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount +1];
        dp[0] = 1;
        for(int i = 1; i <= coins.length; ++i){
            int coin = coins[i - 1];
            for(int j = 0; j <= amount; ++j){
                if(j >= coin){
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
