package HOT100.字符串解码;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        String res = decode(s);
        return res;
    }
    private String findNumEnd(String s, int index){
        for(int i = index+1; i < s.length() ; ++i){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)){
                return s.substring(index, i);
            }
        }
        return "";
    }
    private int findNextIndex(String substring) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < substring.length(); ++i){
            char ch = substring.charAt(i);
            if(ch == '['){
                st.add('[');
            }else if(ch == ']'){
                st.pop();
                if(st.isEmpty())
                    return i + 1;
            }
        }
        return 0;
    }

    public String decode(String sub){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sub.length(); ++i){
            char ch = sub.charAt(i);
            if(ch != '[' && ch != ']' && !Character.isDigit(ch)){
                sb.append(ch);
            }else if(Character.isDigit(ch)){
                // 得到k
                String numStr = findNumEnd(sub, i);
                int num = Integer.parseInt(numStr);
                int numLen = numStr.length();
                i += numLen - 1;
                // 找到最右边括号的位置
                int position = i + findNextIndex(sub.substring(i+1));
                // 得到一个嵌带有中括号的子串 [a2[bc]]
                String decodeString = sub.substring(i + 1, position + 1);
                // 得到中括号解码的子串 abcbc
                String tmp = decode(decodeString);
                for(int j = 0; j < num; ++j){
                    sb.append(tmp);
                }
                i = position;
            }
        }
        return sb.toString();
    }


    // 栈的方法
    private  int p = 0;
    public String decodeString2(String s) {
        LinkedList<String> st = new LinkedList<>();
        while (p < s.length()){
            char ch = s.charAt(p);
            if(Character.isDigit(ch)){
                String numStr = getNum(s);
                st.addLast(numStr);
            }else if (Character.isLetter(ch) || ch == '['){
                st.addLast(String.valueOf(ch));
                ++p;
            }else{
                ++p;
                LinkedList<String> tmp = new LinkedList<>();
                while (!"[".equals(st.peekLast())){
                    tmp.addLast(st.removeLast());
                }
                Collections.reverse(tmp);
                st.removeLast();
                int num = Integer.parseInt(st.removeLast());
                String tmpStr = getString(tmp);
                StringBuilder t = new StringBuilder();
                while (num > 0){
                    t.append(tmpStr);
                    --num;
                }
                st.addLast(t.toString());
            }
        }
        return getString(st);
    }

    private String getString(LinkedList<String> tmp) {
        StringBuilder sb = new StringBuilder();
        for(String c : tmp){
            sb.append(c);
        }
        return sb.toString();
    }

    private String getNum(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(p))){
            sb.append(s.charAt(p++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        // sl.decodeString("3[a]2[bc]");
        sl.decodeString("3[a2[c]]");
    }

}
