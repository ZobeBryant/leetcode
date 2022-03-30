package 贪心.买卖股票的最佳时机2;

public class Solution {

    //动态规划 dp[i][0]表示第二天交易完成后手上没股票 dp[i][1]表示第二天交易完成后手上有股票
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)
            return 0;

        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];

        for(int i=1;i<n;++i){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    //贪心算法
    public int maxProfit2(int[] prices) {

        int max=0;
        int n=prices.length;
        for(int i=1;i<n;++i){
            max+=Math.max(0,prices[i]-prices[i-1]);
        }
        return max;

    }

}
