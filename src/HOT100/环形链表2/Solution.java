package HOT100.环形链表2;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode fast = head, slow = head, start = head;
        while (fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if(slow == fast){
                while (start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}
