package 双指针.移动零;

public class Solution {
    // 不固定长度的滑动窗口 start维持0 end维持非0
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (j < n){
            while (i < n && nums[i] != 0){
                ++i;
            }
            if(i == n)
                break;
            if(j == 0)
                j = i + 1;
            while (j < n && nums[j] == 0){
                ++j;
            }
            if(j == n)
                break;
            nums[i] = nums[j];
            nums[j] = 0;
            ++i;
            ++j;
        }
    }

    // left虽right移动
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                ++left;
            }
            ++right;
        }
    }
}
