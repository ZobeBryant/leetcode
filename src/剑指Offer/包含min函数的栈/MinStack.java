package 剑指Offer.包含min函数的栈;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> st;
    private int min;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        if(st.isEmpty()){
            min = x;
        }
        if( x <= min){
            // 记录上一个min
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    public void pop() {
        if(st.pop() == min) {
           // 还原上一个最小值
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return  min;
    }
}
