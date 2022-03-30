package 贪心.移掉K位数字;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public String removeKdigits(String num, int k) {

        Deque<Character> deque = new LinkedList<>();
        for(int i=0;i<num.length();++i){
            char digit=num.charAt(i);
            while (!deque.isEmpty()&&k>0&&deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for(int i=0;i<k;++i){
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        while(!deque.isEmpty()){
            char digit=deque.pollFirst();
            if(zero&&digit=='0'){
                continue;
            }
            zero=false;
            sb.append(digit);
        }
        return  sb.length()==0?"0":sb.toString();
    }
}
