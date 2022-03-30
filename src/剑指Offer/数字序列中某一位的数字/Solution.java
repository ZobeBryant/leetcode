package 剑指Offer.数字序列中某一位的数字;

public class Solution {
    public int findNthDigit(int n) {
        int digit = 1; //位数
        long start = 1; //起始数字
        long count = 9; //区间数位总数

        //先确定n在哪个数字区间
        while (n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 确定是哪个数字
        long num = start + (n-1) / digit;
        // 确定是数字的哪一位
        int res = String.valueOf(num).charAt((n - 1) % digit) - '0';
        return res;
    }

}
