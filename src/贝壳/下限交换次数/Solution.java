package 贝壳.下限交换次数;

import java.util.Arrays;

public class Solution {
    public int minSwap (long n, long k) {
        // write code here

        String s = Long.toString((n));
        char[] nums = s.toCharArray();
        String tmp = "0";
        Long newN = n;
        int count = 0;
        while ( Long.parseLong(tmp) != n){
            int tmpCount = next(nums, 0);
            tmp = new String(nums);
            if(Long.parseLong(tmp) >= k && Long.parseLong(tmp) < newN ){
                count = tmpCount;
                newN = Long.parseLong(tmp);
            }
        }

        return count;
    }
    public int next(char[] nums, int count){
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
            ++count;
        }
        count = reverse(nums, i + 1, count);
        return count;
    }

    private int reverse(char[] nums, int start, int count) {
        int left = start, right = nums.length - 1;
        while (left < right){
            swap(nums, left, right);
            ++count;
            ++left;
            --right;
        }
        return count;
    }

    public void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int res = sl.minSwap(2211, 1212);
        System.out.println(res);
    }
}
