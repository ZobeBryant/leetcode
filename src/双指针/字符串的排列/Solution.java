package 双指针.字符串的排列;

import java.util.Arrays;

public class Solution {
    private char [] s1_array;
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n == 0)
            return true;
        s1_array = s1.toCharArray();
        Arrays.sort(s1_array);
        for(int i = 0; i + n <= m; ++i){
           boolean temp = judge(s2.substring(i, i + n).toCharArray());
           if(temp == true)
               return true;
        }
        return false;

    }
    public boolean judge(char[] s2){
        int n = s2.length, i = 0;
        Arrays.sort(s2);
        while (i < n){
            if(s1_array[i] != s2[i]){
                return false;
            }
            ++i;
        }
        return true;
    }

    // 固定窗口大小
    public boolean checkInclusion2(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        // 模板数组
        int[] template = new int[26];
        // 匹配数组
        int[] match = new int[26];
        for(int i = 0; i < s1.length(); ++i){
            template[s1.charAt(i) - 'a']++;
            match[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(template, match))
            return true;
        for(int i = s1.length(); i < s2.length(); ++i){
            // 尾字母加入
            match[s2.charAt(i) - 'a']++;
            // 头字母删除
            match[s2.charAt(i - s1.length()) - 'a'] --;
            if(Arrays.equals(match,template))
                return true;
        }
        return false;
    }
}
