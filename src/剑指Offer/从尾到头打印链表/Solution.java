package 剑指Offer.从尾到头打印链表;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        if(node == null)
            return new int[0];
        while (node!=null){
            list.add(node.val);
            node=node.next;
        }
        int[] res = new int[list.size()];
        for(int i =list.size()-1;i>=0;--i){
            res[i]=list.get(list.size()-1-i);
        }
        return res;
    }
}
