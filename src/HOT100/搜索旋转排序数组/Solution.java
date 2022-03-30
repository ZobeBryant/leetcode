package HOT100.搜索旋转排序数组;

public class Solution {
    // 二分 看哪部分是有序的，只处理有序的
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return -1;
        if(n == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target)
                return mid;
            // 左边有序
            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if( nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
