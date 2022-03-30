package 美团秋招.小美练吉他;

import java.util.Scanner;

public class Solution {
    private static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int x = sc.nextInt(),a = sc.nextInt(),b = sc.nextInt(),n = sc.nextInt();
//            recur(x,a,b,n,0);
//            System.out.println(max);
            // dp[i][0] 练习最大收益 dp[i][1]练习最终状态 dp[i][2]休息最终收益 dp[i][3]休息最终状态
            int[][] dp = new int[n][4];
            dp[0][0] = x >=a ? x : 0;
            dp[0][1] = x >=a ? x-a : 0;
            dp[0][2] = 0;
            dp[0][3] = x + b;
            for(int i = 1; i < n;++i){
                // 练习

            }
        }

    }

    public static void recur(int x, int a, int b, int n, int curMax){
        if(n == 0 ){
            if(max < curMax)
                max = curMax;
            return;
        }
        // 练习
        if(x >= a){
            recur(x - a, a, b, n-1,curMax + x );
        }
        // 休息
        recur(x + b, a, b, n-1, curMax);
    }
}
