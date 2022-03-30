package 动态规划.整数拆分;

public class Solution {

    //动态规划
    //dp[i]表示将正整数i拆分成至少两个正整数的和之后，这些正整数的最大乘积
    //将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j*(i-j)
    //将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j*dp[i-j]

    public int integerBreak(int n) {

        int[] dp=new int[n+1];

        for(int i=2;i<=n;++i){
            int curMax=0;
            for(int j=1;j<i;++j){
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curMax;
        }
        return dp[n];
    }


}
