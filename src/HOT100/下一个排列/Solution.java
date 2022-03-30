package HOT100.下一个排列;

import java.util.List;

public class Solution {
    // 找到左边的较小数，找到右边的较大数，较小数尽可能靠右，较大数尽可能小，交换两个数，交换后的大数右边升序排列
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到较小数的位置
        while (i >= 0 && nums[i] >= nums[i + 1]){
            --i;
        }
        // 找到较大数的位置
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                --j;
            }
            if(j > 0)
                swap(nums, i, j);
        }
        // 降序转变为升序
        reverse(nums, i +1);
    }

    private void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right){
            swap(nums, left, right);
            ++left;
            --right;
        }
    }

    public void swap(int[] num, int a, int b){
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

}
