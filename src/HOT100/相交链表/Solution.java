package HOT100.相交链表;

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
        ListNode p = headA;
        ListNode q = headB;
        boolean flagA = true;
        boolean flagB = true;
        while (p != null || q != null){
            if(p == null &&  flagA){
                p = headB;
                flagA = false;
            }
            if(q == null && flagB){
                q = headA;
                flagB = false;
            }
            if(p == q && p != null)
                return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
