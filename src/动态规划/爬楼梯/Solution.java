package 动态规划.爬楼梯;

public class Solution {

    //动态规划
    public int climbStairs(int n) {
        int[] dp = new int[n];
        if( n == 1)
            return 1;
        else if( n == 2)
            return 2;
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;++i){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n-1];

    }

}
