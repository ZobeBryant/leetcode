package HOT100.排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode p = head;
        while (p != null){
            heap.offer(p);
            p = p.next;
        }
        head = heap.poll();
        ListNode q = head;
        while (!heap.isEmpty()){
            q.next = heap.poll();
            q = q.next;
        }
        q.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        Solution sl  = new Solution();
        sl.sortList(head);
    }
}
