package 剑指Offer.连续子数组的最大和;

public class Solution {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; ++i){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int res = nums[0];
        for(int i = 1; i < n; ++ i){
            if(dp[i] > res)
                res = dp[i];
        }

        return res;
    }
}
