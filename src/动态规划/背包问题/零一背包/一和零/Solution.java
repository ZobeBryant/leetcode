package 动态规划.背包问题.零一背包.一和零;

public class Solution {
    // 双目标 三维数组
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for(int i = 1; i <= len; ++i ){
            for(int j = 0; j <= m; ++j){
                for(int k = 0; k <= n; ++k ){
                    int[] cnt = count(strs[i-1]);
                    if(cnt[0] > j || cnt[1] > k)
                        dp[i][j][k] = dp[i-1][j][k];
                    else
                        // 要或不要
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j - cnt[0]][k - cnt[1]] + 1);
                }
            }
        }
        return dp[len][m][n];

    }
    private int[] count(String str) {
        char[] ch = str.toCharArray();
        int[] res = new int[2];
        for(int i = 0; i < ch.length; ++i){
            if(ch[i] == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }


}
