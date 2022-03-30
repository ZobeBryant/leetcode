package 剑指Offer.用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    private Deque stack1;
    private Deque stack2;
    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty() ){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else{
            int deleteItem = (int) stack2.pop();
            return deleteItem;
        }
    }
}
