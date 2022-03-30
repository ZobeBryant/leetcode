package 剑指Offer.调整数组顺序使奇数位于偶数前面;

public class Solution {
    // 双指针
    public int[] exchange(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return nums;
        int i=0,j=n-1;
        int temp;
        while (i<j){
            while (i!=n-1 && nums[i] % 2==1){
                ++i;
            }
            while (j!=0 && nums[j] % 2 ==0){
                --j;
            }
            if(i<j){
                temp = nums[i];
                nums[i]=nums[j];
                nums[j] = temp;
                ++i;
                --j;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
            Solution sl = new Solution();
            int[] nums = new int[]{1,2,3,4};
            sl.exchange(nums);
    }

}
