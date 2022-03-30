package 动态规划.背包问题.零一背包.分割等和子集;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        // 若为奇数 那么一定不能等和分割
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        int n = nums.length;
        // dp[i][j] i表示元素序列 0~i， j表示容量
        boolean[][] dp = new boolean[n][target + 1];

        for(int i = 0; i < n; ++i){
            dp[i][0] = true;
        }

        for(int j = 1; j <= target; ++j){
            dp[0][j] = nums[0] == j;
        }

        for(int i = 1; i < n; ++i){
            for(int j = 1; j <= target; ++j){
               if(j < nums[i]){
                   dp[i][j]  = dp[i-1][j];
               }else{
                   // 当前元素要或不要两种情况，有一种满足即可
                   dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
               }
            }
        }
        return dp[n-1][target];
    }
}

