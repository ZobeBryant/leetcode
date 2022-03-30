package 二分查找.寻找重复数;

public class Solution {
    //双指针法 链表中存在环->找到环的入口
    public int findDuplicate(int[] nums){
        int slow=0,fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int pre1=0,pre2=slow;
        while (pre1!=pre2){
            pre1=nums[pre1];
            pre2=nums[pre2];
        }
        return pre1;
    }

}
