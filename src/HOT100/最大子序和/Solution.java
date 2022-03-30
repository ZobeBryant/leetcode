package HOT100.最大子序和;

public class Solution {
    // dp
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; ++i){
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
