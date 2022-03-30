package 剑指Offer.和为s的两个数字;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; ++i){
            int second = binarySearch(nums, target - nums[i], i + 1);
            if(second != -1)
                return new int[]{nums[i], nums[second]};
        }
        return new int[2];
    }

    public int binarySearch(int[] nums, int target, int start){
        int left = start, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    // 双指针
    public int[] twoSum2(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum == target)
                return new int[]{nums[left], nums[right]};
            else if (sum > target)
                right --;
            else
                left ++;
        }
        return new int[2];

    }
}
