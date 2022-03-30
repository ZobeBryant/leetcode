package 剑指Offer.构建乘积数组;

public class Solution {
    // 动态规划
    // 双dp
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n == 0)
            return new int[0];
        // dp1[i]表示当前位置左边所有元素的乘积
        int[] dp1 = new int[n];
        // dp2[i]表示当前位置右边所有元素的乘积
        int[] dp2 = new int[n];
        dp1[0] = 1;
        dp2[n - 1] = 1;
        int[] res = new int[n];
        for(int i = 1; i < n; ++i){
            dp1[i] = dp1[i-1] * a[i-1];
            dp2[n - i - 1] = dp2[n - i] * a[n - i];
        }
        for(int i = 0; i < n; ++i){
            res[i] = dp1[i] * dp2[i];
        }
        return res;

    }
}
