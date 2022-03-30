package HOT100.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 滑动窗口 双指针
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int i = 0, j = 1;
        int res = 1;
        int count = 1;
        while (j < n){
            char ch2 = s.charAt(j);
            if(!map.containsKey(ch2) || map.get(ch2) < i){
                map.put(ch2, j);
                ++j;
                ++count;
            }else{
                res = Math.max(res, count);
                i = map.get(ch2) + 1;
                count = j - i + 1;
                map.put(ch2,j);
                ++j;
            }
            if(j == n)
                res = Math.max(count, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.lengthOfLongestSubstring("abba");
    }
}
