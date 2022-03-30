package 动态规划.计算各个位数不同的数字个数;

public class Solution {

    /**
     * 排列组合：n位有效数字 = 每一位都从 0~9 中选择，且不能以 0 开头
     * 1位数字：0~9                      10
     * 2位数字：C10-1，且第一位不能是0      9 * 9  C(9,1)*C(9,1)
     * 3位数字：C10-2，且第一位不能是0      9 * 9 * 8
     * 4位数字：C10-3，且第一位不能是0      9 * 9 * 8 * 7
     * ... ...
     * 最后，总数 = 所有 小于 n 的位数个数相加
     */

    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int first=10,second=9*9;

        int size =Math.min(10,n);
        for(int i=2;i<=size;++i){
            first+=second;
            second*=(10-i);
        }
        return first;
    }
}
