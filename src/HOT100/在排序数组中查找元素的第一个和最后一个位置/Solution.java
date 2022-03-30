package HOT100.在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    // 二分
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 0 ){
            return new int[]{-1, -1};
        }
        res[0] = binarySearch(nums, target,true);

        res[1] = binarySearch(nums, target, false);
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean flag){
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                if(!flag && mid < r && nums[mid] == nums[mid + 1]){
                    l = mid + 1;
                }else if(flag && mid > 0 && nums[mid] == nums[mid - 1]){
                    r = mid - 1;
                }else if(mid == r || nums[mid] != nums[mid + 1] || nums[mid] != nums[mid - 1]){
                    return mid;
                }
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = new int[]{5, 7, 7, 8, 10};
        sl.searchRange(nums, 6);
    }
}
