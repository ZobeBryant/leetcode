package 双指针.反转字符串中的元音字母;
import java.util.Arrays;
import java.util.regex.*;
public class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        String reg = "[aeiouAEIOU]";
        char[] c = s.toCharArray();
        while (i < j){
            boolean a = Pattern.matches(reg,s.substring(i,i+1));
            boolean b = Pattern.matches(reg,s.substring(j,j+1));
            if(a && b){
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                ++i;
                --j;
            }else if(a){
                --j;
            }else if(b){
                ++i;
            }else{
                ++i;
                --j;
            }

        }
        String res = new String(c);
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.reverseVowels("hello");
    }
}
