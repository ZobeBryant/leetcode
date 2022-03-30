package 美图.ab串;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[4];
        dp[0] = 2;dp[1] = 2;dp[2] = 1;dp[3] = 1;
        long res = 0;
        if(n == 1)
            System.out.println(2);
        else if(n == 2)
            System.out.println(4);
        else if(n == 3)
            System.out.println(6);
        else{
            for(int i = 4; i <= n; ++i){
                long tmp = dp[0] % 998244353;
                dp[0] = dp[1] = ((dp[0] % 998244353) + (dp[2] % 998244353)) % 998244353;
                dp[2] = dp[3] = tmp;
            }
            for(int i = 0; i < 4; ++i){
                res = ((res % 998244353) + (dp[i] % 998244353)) % 998244353;
            }
            System.out.println(res);
        }
    }
}
// 112272628