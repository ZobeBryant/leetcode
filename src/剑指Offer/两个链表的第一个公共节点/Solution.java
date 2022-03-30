package 剑指Offer.两个链表的第一个公共节点;

public class Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        if(p1 == null || p2 == null )
            return null;
        int flag = 2;
        while (flag >= 0){
            if(p1 == p2)
                return p1;
            if(p1.next != null){
                p1 = p1.next;
            }else{
                p1 = headB;
                flag--;
            }
            if(p2.next != null){
                p2 = p2.next;
            }else {
                p2 = headA;
                flag --;
            }

        }
        return null;
    }
}
