package 网易实习最后一批.噪音字符串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int test(String text1, String text2, char[] ch){
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[m+1][n+1];
        Set<Character> set = new HashSet<>();
        for(char c: ch){
            set.add(c);
        }
        for(int i = 1; i <= m; ++i){
            char ch1 = text2.charAt(i-1);
            for(int j = 1; j <= n; ++j){
                char ch2 = text1.charAt(j-1);
                if(set.contains(ch1) && !set.contains(ch2)){
                    dp[i][j] = dp[i-1][j] + 1;
                }else if(!set.contains(ch1) && set.contains(ch2)){
                    dp[i][j] = dp[i][j-1] + 1;
                }else if(ch1 == ch2 ){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "zxab%c%%a";
        String text2 = "abc%";
        char[] ch = {'%','#'};
        Solution sl = new Solution();
        System.out.println(sl.test(text1, text2, ch));
    }

}
