package 贪心.需要标记.单调递增的数字;

public class Solution {

    public int monotoneIncreasingDigits(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] < nums[i-1]){
                for(int j = i; j < nums.length; ++j){
                    nums[j] = '9';
                }
                nums[i-1] = (char) (nums[i-1] - 1);
                if(i - 2 >= 0)
                    i -= 2;
            }
        }
        return Integer.parseInt(new String(nums));
    }
}
