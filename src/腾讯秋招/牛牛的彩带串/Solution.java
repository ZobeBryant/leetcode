package 腾讯秋招.牛牛的彩带串;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode[] solve (int m, ListNode a) {
        // write code here
        ListNode[] res = new ListNode[m];
        ListNode cur = a;
        ListNode next = a.next;
        while (cur != null){
            if(res[a.val % m] == null){
                res[a.val % m] = cur;
                res[a.val % m].next = null;
            } else{
                ListNode tmp = res[a.val % m].next;
                res[a.val % m].next = cur;
                cur.next = tmp;
            }
            cur = next;
            next = next.next;

        }
        return  res;
    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[2];
        System.out.println(a[0]);
    }
}
