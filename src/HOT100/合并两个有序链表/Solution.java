package HOT100.合并两个有序链表;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode dumpy = new ListNode();
        ListNode p = l1, q = l2, r = dumpy;
        while (p != null && q != null){
            if(p.val <= q.val){
                r.next = p;
                p = p.next;
            }else{
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if(p != null)
            r.next = p;
        else
            r.next = q;
        return dumpy.next;
    }
}
