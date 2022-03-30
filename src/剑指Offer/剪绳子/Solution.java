package 剑指Offer.剪绳子;

public class Solution {
    // 动态规划 由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        for(int i=2;i<=n;++i){
            int curMax=0;
            for(int j=1;j<i;++j){
                curMax=Math.max(curMax,Math.max((i-j)*j,(i-j)*dp[j]));
            }
            dp[i]=curMax;
        }
        return dp[n];
    }
}
