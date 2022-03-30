package 剑指Offer.链表中倒数第k个节点;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = getLength(head);
        int count = len - k;
        ListNode p = head;
        while (count > 0){
            p = p.next;
            --count;
        }
        return p;
    }
    public int getLength(ListNode head){
        ListNode p = head;
        int count=0;
        while (p!=null){
            p=p.next;
            ++count;
        }
        return count;
    }
    // 双指针
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; ++i){
            if(former == null) return null;
            former = former.next;
        }
        while (former!=null){
            latter=latter.next;
            former=former.next;
        }
        return latter;

    }
}
