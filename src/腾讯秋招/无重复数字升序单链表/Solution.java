package 腾讯秋招.无重复数字升序单链表;

import java.util.*;

public class Solution {

      public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }
    public ListNode solve (ListNode[] a) {
        // write code here
        Set<Integer> set = new HashSet<>();
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < a.length; ++i){
            while (a[i] != null){
                if(!set.contains(a[i].val)){
                    set.add(a[i].val);
                    nums.add(a[i].val);
                }
                a[i] = a[i].next;
            }
        }
        nums.sort(Comparator.comparing(o -> o));
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(Integer num: nums){
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        return dummy.next;
    }

}
