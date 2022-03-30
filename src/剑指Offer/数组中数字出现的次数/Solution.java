package 剑指Offer.数组中数字出现的次数;

public class Solution {
    //异或 分组
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        // 得到两个出现一次元素的异或值 相同元素的异或值为0
        for(int n : nums){
            res ^= n;
        }
        int div = 1;
        while ((div & res) == 0){
            // 左移一位
            div <<= 1;
        }
        int a = 0, b = 0;
        // 分组异或
        for(int n: nums){
            if((n & div) == 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }
        return new int[]{a, b};

    }
}
