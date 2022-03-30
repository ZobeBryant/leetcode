package 剑指Offer.字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private List<String> res = new ArrayList<>();
    private char[] c;
    // 全排列问题
    public String[] permutation(String s) {

        c = s.toCharArray();
        dfs(0);
        return  res.toArray(new String[res.size()]);
    }
    // 固定位置
    public void dfs(int pos){
        if(pos == c.length - 1)
            res.add(String.valueOf(c));
        Set<Character> set = new HashSet<>();
        for(int i = pos; i < c.length; ++i){
            if(set.contains(c[i])) continue; //与当前位置重复字符直接跳过
            set.add(c[i]);
            swap(i, pos);
            dfs(pos + 1);
            swap(i, pos);
        }
    }
    public void swap(int a, int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


}
