package HOT100.有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i = 1; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() == map.get(ch)){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
}
