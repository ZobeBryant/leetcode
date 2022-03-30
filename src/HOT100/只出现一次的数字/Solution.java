package HOT100.只出现一次的数字;

public class Solution {
    // 位运算 异或运算(相同为零，不同为1)
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for(int i = 1; i < nums.length; ++i){
            a ^= nums[i];
        }
        return a;
    }
}
