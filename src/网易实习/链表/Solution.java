//package 网易实习.链表;
//
//public class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode pre = new ListNode(0);
//        ListNode p = pre;
//        int carry = 0;
//        while (l1 != null || l2 != null) {
//            // 位数不同，补0。
//            int x = l1 == null ? 0 : l1.val;
//            int y = l2 == null ? 0 : l2.val;
//
//            // 计算两个数的和
//            int sum = x + y + carry;
//            // 计算进位值
//            carry = sum > 9 ? 1 : 0;
//            // 添加计算结果
//            p.next = new ListNode(sum % 10);
//
//            // p移位
//            p = p.next;
//            // l1、l2移位
//            if (l1 != null)
//                l1 = l1.next;
//            if (l2 != null)
//                l2 = l2.next;
//        }
//        // 处理最高位（如果有进位）
//        if (carry == 1)
//            p.next = new ListNode(1);
//        return pre.next;
//    }
//}
