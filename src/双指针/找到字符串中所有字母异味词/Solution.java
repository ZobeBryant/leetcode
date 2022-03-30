package 双指针.找到字符串中所有字母异味词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 固定窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length())
            return res;
        // 模板
        int[] template = new int[26];
        // 匹配
        int[] match = new int[26];

        for(int i = 0; i < p.length(); ++i){
            template[p.charAt(i) - 'a']++;
            match[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(template, match))
            res.add(0);
        for(int i = p.length(); i < s.length(); ++i){
            // 队尾加入新的字符
            match[s.charAt(i) - 'a']++;
            // 删除队首的字符
            match[s.charAt(i - p.length()) - 'a']--;
            if(Arrays.equals(match,template))
                res.add(i - p.length() + 1);
        }
        return res;
    }
}
