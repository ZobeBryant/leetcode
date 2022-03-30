package 前缀法.每个元音包含偶数次的最长子字符串;

import java.util.Arrays;

public class Solution {

    // 前缀 + 压缩
    public static int findTheLongestSubstring(String s) {
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -2);
        int cur = 0;
        int ans = 0;
        //0代表出现偶数次 1代表出现奇数次
        // p[0]相当于所有元音字母都为偶数
        pos[0] = -1;
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            switch (c){
                case 'a':
                    cur ^= 1;
                break;
                case 'e':
                    cur ^= 2;
                    break;
                case 'i':
                    cur ^= 4;
                    break;
                case 'o':
                    cur ^= 8;
                    break;
                case 'u':
                    cur ^= 16;
                    break;
                default:
                    break;
            }
            if(pos[cur] != -2)
                ans = Math.max(ans, i  - pos[cur]);
            else
                pos[cur] = i ;
        }
        return ans;
    }

    public static void main(String[] args) {

        findTheLongestSubstring("aa");
    }
}
