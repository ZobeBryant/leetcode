package 贪心.任务调度.重构字符串;

import java.util.*;

public class Solution {
    // 优先选择剩余数量最多的字母 与任务调度器的模拟法类似
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> nextPos = new ArrayList<>(); // 下一个位置
        List<Character> ch = new ArrayList<>();  // 字母
        List<Integer> rest = new ArrayList<>(); // 剩余数量
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character, Integer> entry: entries){
            ch.add(entry.getKey());
            rest.add(entry.getValue());
            nextPos.add(0);
        }
        int pos = 0; // 当前位置
        int m = map.size(); // 不同字母数量
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            int maxRest = -1, maxPos = -1;
            for(int j = 0; j < m; ++j){
                if(rest.get(j) != 0){
                    if(nextPos.get(j) <= pos){
                        if(maxRest < rest.get(j)){
                            maxRest = rest.get(j);
                            maxPos = j;
                        }
                    }
                }
            }
            if(maxRest == -1){
                return "";
            }
            res.append(ch.get(maxPos));
            rest.set(maxPos, rest.get(maxPos) - 1);
            nextPos.set(maxPos, pos + 2);
            ++pos;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.reorganizeString("aab");

    }

}
