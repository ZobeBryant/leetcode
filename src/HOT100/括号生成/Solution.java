package HOT100.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(StringBuilder sb, int open, int close, int max){
        if(sb.length() == 2 * max){
            res.add(new String(sb.toString()));
            return;
        }
        if(open < max){
            backtrack(sb.append("("), open +1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            backtrack(sb.append(")"), open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
