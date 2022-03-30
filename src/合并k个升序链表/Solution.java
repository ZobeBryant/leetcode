package 合并k个升序链表;

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(int i = 0; i < lists.length; ++i){
            res = sort(res,lists[i]);
        }
        return res;
    }

    public ListNode sort(ListNode A, ListNode B){
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (A != null && B != null){
            if(A.val <= B.val){
                p.next = A;
                A = A.next;
            }else{
                p.next = B;
                B = B.next;
            }
            p = p.next;
        }
        p.next = A == null ? B : A;
        return head.next;
    }

    // 归并排序
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists,0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l == r)
            return lists[l];
        if(l > r)
            return null;
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a == null || b == null){
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (a != null && b != null){
            if(a.val <= b.val){
                p.next = a;
                a = a.next;
            }else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }

        p.next = a == null ? b : a;
        return head.next;
    }

}
