package 二分查找.数组全部有序.有序数组的单一元素;

public class Solution {
    /*
    *   1.判断出现单一元素之前和单一元素之后相同数字的下标即可。
        2.出现单一元素之前，重复数字的下标为偶、奇排列；出现单一元素之后，重复数字的下标为奇、偶排列。
        3.仅对偶数索引进行二分查找
            查找中间偶数位的值与右边是否相等，相等异常在右边，不相等异常在左边或mid处。
            如果中间是奇数位，-1再判断
            当left>=right时，left的元素为最终的单个值
    * */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int left = 0, right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(mid % 2 == 1)
                mid--;
            if(nums[mid] == nums[mid + 1]){
                left = mid + 2;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}
