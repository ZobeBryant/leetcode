package HOT100.跳跃游戏;

public class Solution {
    // 回溯 emmm超时
    public boolean canJump(int[] nums) {
        backTrack(nums, 0);
        return res;
    }

    private boolean res = false;
    public void backTrack(int[] nums, int index){
        if(index == nums.length - 1){
            res = true;
            return;
        }else if(nums[index] == 0){
            return;
        }
        for(int i = 1; i <= nums[index]; ++i){
            if(i + index < nums.length){
                backTrack(nums, index + i );
            }
        }
    }


    // 维护最远到达的位置
    public boolean canJump1(int[] nums) {
        int maxRight = nums[0];
        int n = nums.length;
        int i = 0;
        while (i <= maxRight && i < n){
            maxRight = Math.max(maxRight, i + nums[i]);
            ++i;
            if(maxRight >= n - 1)
                return true;
        }
            return false;
    }
}
