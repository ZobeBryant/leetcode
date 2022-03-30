package 贪心.分配问题.分发饼干;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p = 0, q = 0;
        int count = 0;
        while (p < g.length && q < s.length){
            if(g[p] <= s[q]){
                ++count;
                ++p;
                ++q;
            }else{
                ++q;
            }
        }
        return count;
    }
}
