package HOT100.回文子串;

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = n;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if(judge(s.substring(i, j + 1)))
                    ++count;
            }
        }
        return count;
    }
    public boolean judge(String s){
        int n = s.length();
        for(int i = 0; i < n / 2; ++i){
            if(s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public int countSubstrings2(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("$#");
        for(int i = 0; i < n; ++i){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        n = sb.length();
        sb.append('!');
        // f[i]记录的是sb字符串以i为中心的最大半径，f[i] - 1表示的是s字符串以i为中心的最大回文串长度
        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for(int i = 1; i < n; ++i){
            // 初始换f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            //中心扩展
            while (sb.charAt(i - f[i]) == sb.charAt(i + f[i])){
                ++f[i];
            }
            // 动态维护iMax和rMax
            if(i + f[i] - 1 > rMax){
                iMax = i;
                rMax = i + f[i] - 1;
            }
            ans += f[i] / 2;
        }
        return ans;
    }

}
