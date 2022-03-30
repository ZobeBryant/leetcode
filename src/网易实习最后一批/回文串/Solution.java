package 网易实习最后一批.回文串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // dp[i][j]表示s[i..j]是否是回文串
    public int test(String s, char[] ch){
        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        for(char c:ch){
//            set.add(c);
//        }
       boolean[][] dp = new boolean[n][n];
        // 一个字符必是回文串
        for(int i = 0; i < n; ++i){
            dp[i][i] = true;
        }
        int max = 0;
        for(int len = 2; len < n; ++len){
            for(int l = 0; l < n - len + 1; ++l){
               int r = l + len - 1;
               if(s.charAt(l) != s.charAt(r))
                   dp[l][r] = false;
               else{
                   if(len == 2){
                       dp[l][r] = true;
                   }else{
                       dp[l][r] = dp[l+1][r-1];
                   }
               }
                if(dp[l][r] && judge(s,l,r+1,ch) && r - l + 1 > max){
                    max = r - l + 1;
                }
            }
        }
        return max;
    }

    public boolean judge(String s, int l, int r, char[] ch) {
        String str = s.substring(l, r);
        for(int i = 0; i < ch.length; ++i){
            if(str.contains(Character.toString(ch[i]))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "abbaca";
        char[] ch = {'b', 'x'};
        //System.out.println(sl.judge(s,3,6,ch));
        System.out.println(sl.test(s,ch));
    }
}
