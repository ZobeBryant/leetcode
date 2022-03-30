package 工商银行;

public class Solution2 {
    public static void main(String[] args) {

        System.out.println(getLen("ababbabab"));
    }

    public static int getLen(String s ){
        int index = 0;
        int n = s.length();
        int max = 1;
        int []dp = new int[s.length()];
        dp[0] = 1 ;
        for (index=1 ; index < n ; index++){

            if (s.charAt(index) != s.charAt(index-1)){
                dp[index] = dp[index - 1] + 1;
            }else {
                dp[index] = 1;
            }
            max = Math.max(dp[index], max);
        }

        return max;
    }
}
