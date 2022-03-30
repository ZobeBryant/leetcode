package 网易秋招.航海探险;

public class Solution {
    public int minSailCost (int[][] input) {
        // write code here
        int m = input.length;
        int n = input[0].length;
        if(m == 0 || n == 0)
            return  -1;
        int[][] dp = new int[m][n];
        for(int j = 1; j < n; ++j){
            if(input[0][j] != 2 && dp[0][j - 1] != Integer.MAX_VALUE){
                dp[0][j] = dp[0][j - 1];
                if(input[0][j] == 0)
                    dp[0][j] += 2;
                else
                    dp[0][j] += 1;
            }else{
                dp[0][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i < m; ++i){
            if(input[i][0] != 2 && dp[i - 1][0] != Integer.MAX_VALUE){
                dp[i][0] = dp[i - 1][0] ;
                if(input[i][0] == 0)
                    dp[i][0] += 2;
                else
                    dp[i][0] += 1;
            }else{
                dp[i][0] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(input[i][j] != 2 ){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    if(dp[i][j] != Integer.MAX_VALUE){
                        if(input[i][j] == 0)
                            dp[i][j] += 2;
                        else
                            dp[i][j] += 1;
                    }
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        if(dp[m - 1][n - 1] != Integer.MAX_VALUE){
            return dp[m - 1][n - 1];
        }else
            return -1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        // [[1,1,1,1,0],[0,1,0,1,0],[1,1,2,1,1],[0,2,0,0,1]]
        int[][] input = new int[][]{{1,1,1,1,0}, {0,1,0,1,0}, {1,1,2,1,1}, {0,2,0,0,1}};
        sl.minSailCost(input);
    }
}
