package 剑指Offer.删除链表的节点;

public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        if(head.val==val){
            head=head.next;
        }else{
            while (p.next.val!=val){
                p=p.next;
            }
            p.next = p.next.next;
        }
        return head;
    }
}
