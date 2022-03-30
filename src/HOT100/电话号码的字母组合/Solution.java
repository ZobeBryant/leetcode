package HOT100.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0)
            return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recur(digits, 0 , sb, n);
        return res;
    }
    private List<String> res = new ArrayList<>();
    // 回溯
    public void recur(String digits, int index, StringBuilder sb, int n){
        if(index == n){
            res.add(sb.toString());
            return;
        }
        char[] c = lookup(digits.charAt(index));
        for(int i = 0; i < c.length; ++i){
            sb.append(c[i]);
            recur(digits, index + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public char[] lookup(char num){
        switch (num){
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.letterCombinations("23");
    }
}
