package HOT100.最长回文子串;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("$#");
        for(int i = 0; i < n; ++i){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        n = sb.length();
        sb.append("!");
        int[] f = new int[n];
        int iMax = 0, rMax = 0, count = 0, start = -1, end = -1;
        for(int i = 1; i < n; ++i){
            // 初始化f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;

            // 中心扩展
            while (s.charAt(i - f[i]) == s.charAt(i + f[i])){
                ++f[i];
            }
            if(i + f[i] - 1 > rMax){
                iMax = i;
                rMax = i + f[i] - 1;
                if(count < f[i] - 1){
                    count = f[i] - 1;
                    start = i - f[i] + 1;
                    end = i + f[i] - 1;
                }
            }
        }
        String tmp = s.substring(start, end + 1);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < tmp.length(); ++i){
            char ch = tmp.charAt(i);
            if(ch != '#')
                res.append(ch);
        }
        return res.toString();
    }
}
