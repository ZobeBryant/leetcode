package HOT100.不同的二叉搜索树;

public class Solution {
    // 动态规划
    // g(n)表示长度为n的二叉搜索树的个数 f(i, n)表示以i为根节点长度为n的二叉搜索树的个数 g(n) = sum(f(i,n)) f(i,n) = g(i-1) * g(n - i);
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                dp[i] += dp[j - 1]* dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        int[] dp = new int[n +1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
