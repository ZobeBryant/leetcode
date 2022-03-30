package 网易秋招.计算k位;

public class Solution {

    public char findKthBit (int n, int k) {
        // write code here
        char[] l = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] s = new String[n];
        s[0] = "a";
        for(int i = 1; i < n; ++i){
            StringBuilder sb = new StringBuilder();
            sb.append(s[i - 1]);
            sb.append(l[i]);
            String iv = invert(s[i - 1], l);
            String re = reverse(iv);
            sb.append(re);
            s[i] = sb.toString();
        }
        char res = s[n - 1].charAt(k - 1);
        return res;
    }

    public String invert(String s, char[] l){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            int index = 25 - (s.charAt(i) - 'a');
            char tmp = l[index];
            sb.append(tmp);

        }
        return sb.toString();
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            int index = s.length() - i - 1;
            sb.append(s.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.findKthBit(4,1);
    }
}
