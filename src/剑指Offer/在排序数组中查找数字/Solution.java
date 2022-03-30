package 剑指Offer.在排序数组中查找数字;

public class Solution {
    // 二分查找
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int pos = -1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                pos = mid;
                break;
            }
            else if (nums[mid] >  target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if(pos == -1)
            return 0;
        else
            return count(nums, pos);
    }

    public int count(int[] nums, int pos){
        int count = 1;
        // pos前
        int p1 = pos -1;
        while (p1 >= 0){
            if(nums[p1] == nums[pos]){
                p1--;
                count++;
            }
            else
                break;
        }
        // pos后
        int p2 = pos + 1;
        while (p2 < nums.length){
            if(nums[p2] == nums[pos]){
                p2++;
                count++;
            }
            else
                break;
        }
        return count;
    }
}
