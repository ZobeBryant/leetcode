package 链表.移除链表元素;

public class Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    //val相同的可能有多个节点
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;

        ListNode prv=dummyHead;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val)
                prv.next=cur.next;
            else
                prv=prv.next;
            cur=cur.next;
            
        }
        return dummyHead.next;
    }

}
