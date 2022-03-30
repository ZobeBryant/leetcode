package 剑指Offer.把数字翻译成字符串;

public class Solution {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 与前一位数组合
        dp[0][1] = 1; // 与前一位数不组合
        for(int i = 1; i < n; ++i){
            int temp = Integer.parseInt(str.substring(i-1,i+1));
            int cur = Integer.parseInt(str.substring(i, i+1));
            if(temp <= 25 && temp != cur  ){
                dp[i][0] = dp[i-1][1];

            }else{
                dp[i][0] = 0;
            }
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }
        return dp[n-1][0] + dp[n-1][1];
    }

    // dp[i] = dp[i-1] + dp[i-2]
    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for( int i = 1; i < n; ++i){
            int temp = Integer.parseInt(str.substring(i-1,i+1));
            dp[i]+= dp[i-1];
            if(temp <= 25 && temp >=10){
                if(i == 1)
                    dp[i] += 1;
                else
                    dp[i] +=dp[i-2];
            }
        }
        return dp[n-1];
    }
    // 滚动数组
    public int translateNum3(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int p = 0, q = 0, r = 1; // p、q、r分别对应着dp[i-2]、dp[i-1]和dp[i]
        for( int i = 0; i < n; ++i){
            p = q;
            q = r;
            r = 0;
            r += q;
            if(i == 0)
                continue;
            int temp = Integer.parseInt(str.substring(i-1,i+1));
            if(temp <=25 && temp >=10)
                r += p;
        }
        return r;
    }
    public static void main(String[] args) {
        int num = 12258;
        String str = String.valueOf(num);
        System.out.println(str.substring(1,3));
    }
}
