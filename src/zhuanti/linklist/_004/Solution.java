//package zhuanti.linklist._004;
//
//import leetcode.solution.structure.ListNode;
//
//public class Solution {
//    /**
//     * 反转部分单向链表
//     * 1 2 3 4 5 null 2 4
//     * 1 4 3 2 5 null
//     */
//    public static ListNode reversePart(ListNode head, int from, int to) {
//        int len = 0;
//        ListNode node1 = head;
//        ListNode pre = null, after = null;
//        while (node1 != null) {
//            len ++;
//            pre = len == from - 1 ? node1 : pre;
//            after = len == to + 1 ? node1 : after;
//            node1 = node1.next;
//        }
//        if(from > to || from < 1 || to > len)
//            return head;
//        node1 = pre == null ? head : pre.next;
//        ListNode node2 = node1.next;
//
//    }
//}
