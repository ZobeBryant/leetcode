package 链表.删除链表中的节点;

public class Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
    }

}
