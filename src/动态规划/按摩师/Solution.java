package 动态规划.按摩师;

public class Solution {

    public int massage(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; ++i){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int res = dp[0];
        for(int i = 1; i < n; ++i){
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
