package 剑指Offer.不用加减乘除做加法;

public class Solution {
    // 考察位运算 两数异或代表无进位和 两数相与代表进位值
    public int add(int a, int b) {
        while (b!=0){
            int c = (a&b)<<1;
            a ^= b;
            b = c;
        }
        return  a;
    }
}
