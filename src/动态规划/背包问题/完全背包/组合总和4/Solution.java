package 动态规划.背包问题.完全背包.组合总和4;

public class Solution {
    // 排列数 容量在最外层 物品在最里层
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; ++i){
            for(int j = 0; j < n; ++j){
                // 题目说顺序不同的序列视为不同的组合 那么我们要统计以nums[j]结尾的不同排列数
                if(i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(sl.combinationSum4(nums, 4));
    }
}
