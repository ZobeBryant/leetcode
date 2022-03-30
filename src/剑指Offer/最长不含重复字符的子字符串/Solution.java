package 剑指Offer.最长不含重复字符的子字符串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 滑动窗口 需要借助hashset
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left= 0,right = 0;
        int res = 0;
        while (right < s.length()){
            if(!set.contains(s.charAt(right))){
                // 没有重复
                set.add(s.charAt(right));
                ++right;
            }else{
                // 重复
                res = Math.max(res, right - left );
                set.remove(s.charAt(left));
                ++left;
            }
        }

        res = Math.max(res, set.size());
        return res;
    }
}
