package 贪心.跳跃游戏;

public class Solution {

    public boolean canJump(int[] nums) {
        int mostRight=0;
        int n=nums.length;
        for(int i=0;i<n;++i){
            if(i<=mostRight){
                mostRight=Math.max(mostRight,i+nums[i]);
            }
            if(mostRight>=n-1)
                return true;
        }
        return false;
    }

}
