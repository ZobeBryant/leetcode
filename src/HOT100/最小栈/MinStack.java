package HOT100.最小栈;

import org.omg.CORBA.MARSHAL;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> st;
    private int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // 存储之前的最小值
        st.push(min);
        min = Math.min(val,min);
        st.push(val);
    }

    public void pop() {
        st.pop();
        min = st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
