package HOT100.环形链表;

import java.util.List;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode first = head;
        ListNode second = head.next.next;
        while (second != null){
            if(first == second){
                return true;
            }
            first = first.next;
            second = second.next;
            if(second != null)
                second = second.next;
        }
        return false;
    }
}
