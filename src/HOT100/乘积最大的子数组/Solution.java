package HOT100.乘积最大的子数组;

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int res = nums[0];
        dp1[0] = dp2[0] = nums[0];
        for(int i = 1; i < n; ++i){
            dp1[i] = Math.max(dp1[i - 1] * nums[i], Math.max(nums[i], dp2[i - 1] * nums[i]));
            dp2[i] = Math.min(dp1[i - 1] * nums[i], Math.min(nums[i], dp2[i - 1] * nums[i]));
            res = Math.max(res, dp1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        Solution sl = new Solution();
        sl.maxProduct(nums);
    }
}
