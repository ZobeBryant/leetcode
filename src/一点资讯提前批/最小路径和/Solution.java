package 一点资讯提前批.最小路径和;

public class Solution {
    public int findMin (int[][] mapArray) {
        // write code here
        int m = mapArray.length;
        int n = mapArray[0].length;
        if(m == 0 || n == 0 || mapArray == null)
            return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = mapArray[0][0];
        for(int i = 1; i < m; ++ i){
            dp[i][0] = dp[i - 1][0] + mapArray[i][0];
        }
        for(int j = 1; j < n; ++ j){
            dp[0][j] = dp[0][j - 1] + mapArray[0][j];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j -1]) + mapArray[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}
