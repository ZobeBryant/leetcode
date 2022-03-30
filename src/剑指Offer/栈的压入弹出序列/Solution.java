package 剑指Offer.栈的压入弹出序列;

import java.util.Stack;

public class Solution {

    // 模拟法
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        if (n == 0)
            return true;
        int pos1 = 0, pos2 = 0;
        boolean flag = true;
        while (true){
            st.add(pushed[pos1]);
            while (!st.isEmpty() && st.peek() == popped[pos2]){
                ++pos2;
                st.pop();
            }
            ++pos1;
            if(pos1 == n && !st.isEmpty()){
                flag = false;
                break;
            }else if(pos1 == n && st.isEmpty()){
                break;
            }
        }
        return flag;
    }
}
