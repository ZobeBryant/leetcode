package 剑指Offer.复杂链表的复制;

public class Solution {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node h =head;
        while (h != null){
            Node q = new Node(h.val);
            q.next = h.next;
            h.next = q;
            h = q.next;
        }
        h = head;
        while (h != null){
            if(h.random != null)
                h.next.random = h.random.next;
            h = h.next.next;
        }
        Node old_list = head;
        Node new_list = head.next;
        Node new_head = head.next;
        while (old_list != null){
            old_list.next = old_list.next.next;
            if (new_list.next != null)
                new_list.next = new_list.next.next;
            old_list = old_list.next;
            new_list = new_list.next;
        }
       /* Node h3 = head;
        Node p1;
        while (h3.next.next != null ){
            p1 = h3.next.next;
            h3.next.next = p1.next;
            h3.next = p1;
            h3 = p1;
        }
        h3.next = null;*/
        return new_head;
    }
}
