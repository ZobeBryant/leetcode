package 动态规划.最长公共子序列;

public class Solution {
    // dp[i][j]表示字符串1以i-1结尾和字符串2以j-1结尾，两个字串的最大公共字串长度
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i ){
            for(int j = 1; j <= n; ++j){
                if(text1.charAt(j-1) == text2.charAt(i-1))
                    // 当前位置的字符一样
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    // 当前位置的字符不一样
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];

    }
}
