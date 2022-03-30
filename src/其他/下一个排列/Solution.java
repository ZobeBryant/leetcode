package 其他.下一个排列;

import java.util.Arrays;

public class Solution {
    //当前排列在全排列中的下一个排列

    //思路：让下一个排列变大的幅度尽可能小 找到一个较小数和较大数 交换较小数和较大数之后 让较大数右边升序排列
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0 &&nums[i]>=nums[i+1]){
            --i;
        }
        if(i>=0){
            int j =nums.length-1;
            while (j>=0 &&nums[i]>=nums[j]){
                --j;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);

    }

    public void swap(int nums[],int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }

    public void  reverse(int[] nums, int start){
        int left = start, right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            ++left;
            --right;
        }
    }
}
