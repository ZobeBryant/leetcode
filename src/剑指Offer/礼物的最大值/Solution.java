package 剑指Offer.礼物的最大值;

public class Solution {

    private int res = Integer.MIN_VALUE;

    // 递归超时
    public int maxValue(int[][] grid) {
        recur(grid,0,0,0);
        return res;
    }
    // 超时
    public void recur(int[][] grid, int i, int j, int count){
        if(i > grid.length-1 || j > grid[0].length-1)
            return;
        count += grid[i][j];
        if(i == grid.length-1 && j == grid[0].length-1 ){
            if(res < count)
                res = count;
            return;
        }
        recur(grid,i+1,j,count);
        recur(grid, i, j+1, count);


    }
    // 动态规划 dp[i][j] = Math.math(dp[i-1][j], dp[i][j-1])
    public int maxValue2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int t1 = 0, t2 = 0;
        for(int i = 0;i < n; ++i){
            t1 += grid[i][0];
            dp[i][0] = t1;
        }
        t2 += grid[0][0];
        for(int j = 1; j < m; ++j){
            t2 += grid[0][j];
            dp[0][j] = t2;
        }
        for(int i = 1; i < n; ++i){
            for(int j = 1; j < m; ++j){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }


}
