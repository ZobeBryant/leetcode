package 剑指Offer.反转链表;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode first = null,second = head, third = head.next;

        while (second !=null){
            second.next=first;
            first=second;
            second=third;
            if(third != null){
                third=third.next;
            }
        }
        return first;
    }
}
