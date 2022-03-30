package 动态规划.背包问题.零一背包.目标和;

public class Solution {
    // 只过了90%的测试用例
    public int findTargetSumWays(int[] nums, int target) {
        int sum =  sum(nums);
        if(target > sum)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][2*sum + 1];
        dp[0][ sum - nums[0]] = 1;
        dp[0][sum + nums[0]] = 1;
        for(int i = 1; i < n; ++ i ){
            for(int j = 0; j <= 2 * sum; ++j){
                if(j - nums[i] >= 0)
                    dp[i][j] += dp[i - 1][j - nums[i]];
                if((j + nums[i]) <= 2 * sum)
                    dp[i][j] += dp[i - 1][j + nums[i]];
            }
        }

        return dp[n-1][sum + target];
    }
    // 正数集合s 负数集合n s-n = target => 变形 2s = target + (s + n)
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = sum(nums);
        if((target + sum) % 2 == 1 || sum < target)
            return 0;
        int s = (target + sum) / 2;
        int n = nums.length;
        int[][] dp = new int[n+1][s+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j <= s; ++j){
                dp[i][j] = dp[i-1][j];
                if(j - nums[i-1]>= 0){
                   dp[i][j] += dp[i-1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][s];
    }

    private int sum(int[] nums) {
        int res = 0;
        for(int num : nums){
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        Solution sl = new Solution();
        sl.findTargetSumWays(a, 3);
    }
}
