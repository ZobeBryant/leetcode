package HOT100.每日温度;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if(temperatures[i] < temperatures[j]){
                    res[i] = j - i;
                    break;
                }
                if(j == n - 1)
                    res[i] = 0;
            }
        }
        return res;
    }

    // 单调栈
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n; ++i){
            int tmp = temperatures[i];
            while (!st.isEmpty() && temperatures[st.peek()] < tmp){
                int index = st.pop();
                res[index] = i - index;
            }
            st.push(i);
        }
        return res;
    }
}
