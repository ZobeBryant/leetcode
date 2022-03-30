package 剑指Offer.缺失的数字;

public class Solution {
    // 排序数组首先想到的是二分查找
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == mid)
                left++;
            else
                right--;
        }
        return left;
    }
}
