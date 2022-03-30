package 剑指Offer.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    private Queue<Integer> q;
    private Deque<Integer> d;
    public MaxQueue() {
        q = new LinkedList();
        // d维持一个单调递减的序列，根据队列的性质，前面的局部最大值小于当前值，那么前面的局部值可以舍弃
        d = new LinkedList<>();
    }

    public int max_value() {
        if(d.isEmpty()){
            return -1;
        }
        return d.peekFirst();

    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value){
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);

    }

    public int pop_front() {
        if(q.isEmpty())
            return -1;
        int curValue = q.poll();
        if(curValue == d.peekFirst()){
            d.pollFirst();
        }

        return curValue;
    }
}
