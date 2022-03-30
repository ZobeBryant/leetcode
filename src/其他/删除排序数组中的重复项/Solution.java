package 其他.删除排序数组中的重复项;

public class Solution {
    //双指针
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int i = 0;
        for(int j=1; j<nums.length;++j){
            if(nums[i]!=nums[j]){
                ++i;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }


}
