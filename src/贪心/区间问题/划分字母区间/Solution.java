package 贪心.区间问题.划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 贪心思想 每次取的片段都是符合要求的最短长度，因此得到的长度片段数也是最多的
    public List<Integer> partitionLabels(String s) {
        int[] pos = new int[26];
        // 存储每个字母的最大位置
        for(int i = 0; i < s.length(); ++i){
            pos[s.charAt(i) - 'a'] = i;
        }
        // start记录当前位置 end当前片段内所能到达的最大位置 temp记录每一段的起始位置
        int start = 0, end = 0, temp = 0;
        List<Integer> res = new ArrayList<>();
        while(start < s.length()){
            end = Math.max(end, pos[s.charAt(start) - 'a']);
            if(end == start){
                res.add(end - temp + 1);
                temp = start + 1;
            }
            ++start;
        }
        return res;
    }
}
