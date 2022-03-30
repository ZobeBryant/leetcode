package HOT100.删除链表的倒数第N个节点;

public class Solution {

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val; this.next = next;
        }
    }
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy, q = head;
        int t = n;
        while (q != null && t > 1 ){
            q = q.next;
            --t;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
