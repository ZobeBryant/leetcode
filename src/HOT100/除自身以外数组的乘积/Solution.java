package HOT100.除自身以外数组的乘积;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 1;
        dp2[n-1] = 1;
        for(int i = 1; i < n; ++i){
            dp1[i] = dp1[i-1] * nums[i-1];
            dp2[n-1-i] = dp2[n-i] * nums[n-i];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; ++i){
            res[i] = dp1[i] * dp2[i];
        }
        return res;
    }
}
