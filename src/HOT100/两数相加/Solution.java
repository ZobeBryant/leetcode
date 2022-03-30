package HOT100.两数相加;

import java.util.List;

public class Solution {
    class ListNode{
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
    // 太麻烦
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode pre = null;
        while (p != null && q != null ){
            int sum = p.val + q.val;
            p.val = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            if(pre != null){
                pre = pre.next;
            }else{
                pre = p;
            }
            p = p.next;
            q = q.next;
        }
        if(p == null && q == null){
            if(carry != 0){
                p = pre;
                p.next = new ListNode(1);
                p.next.next = null;
            }
        }else if(p != null){
            while (carry != 0 && p != null){
                int sum = p.val;
                p.val = (sum + carry) % 10;
                carry = (sum + carry) / 10;
                p = p.next;
                pre = pre.next;
            }
            if(p == null && carry != 0){
                p = pre;
                p.next = new ListNode(1);
                p.next.next = null;
            }
        }else if(q != null){
            p = pre;
            p.next = q;
            p = p.next;
            while (carry != 0 && p != null){
                int sum = p.val;
                p.val = (sum + carry) % 10;
                carry = (sum + carry) / 10;
                pre = pre.next;
                p = p.next;
            }
            if(p == null && carry != 0){
                p = pre;
                p.next = new ListNode(1);
                p.next.next = null;
            }
        }
        return l1;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if(head == null){
                head= tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry > 0){
            tail.next = new ListNode(1);
        }
        return head;
    }



}
