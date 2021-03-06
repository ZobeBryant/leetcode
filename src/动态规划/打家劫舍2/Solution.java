package 动态规划.打家劫舍2;

import java.util.Arrays;

public class Solution {

    //房间是环形排列的(即首尾相接) 意味着第一个房子和最后一个房子只能选择一个偷窃

    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];

        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int myRob(int[] nums){

        int pre=0, cur=0,tmp;

        for(int num: nums){
            tmp=cur;
            cur=Math.max(pre+num,cur);
            pre=tmp;
        }
        return cur;
    }

}
