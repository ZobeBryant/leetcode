package HOT100.最短无序连续子数组;

import java.util.Arrays;

public class Solution {
    // 排序
    public int findUnsortedSubarray(int[] nums) {
        int[] numsNew = nums.clone();
        Arrays.sort(numsNew);
        int start = -1, end = -1;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != numsNew[i]){
                start = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] != numsNew[i]){
                end = i;
                break;
            }
        }
        if(start <= end && start != -1)
            return end - start + 1;
        else
            return 0;
    }

    // 思想是找到无序数组的左右边界
    public int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // 找到无序数组左边界值
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] - nums[i-1] < 0){
                min = Math.min(min, nums[i]);
            }
        }
        // 找到无序数组右边界值
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i + 1] - nums[i] < 0){
                max =Math.max(nums[i], max);
            }
        }
        int l, r;
        for( l = 0; l < nums.length; ++l){
            if(nums[l] > min )
                break;
        }
        for(r = nums.length - 1; r >= 0; --r ){
            if(nums[r] < max)
                break;
        }
        return r - l < 0 ? 0: r - l + 1;
    }

}
