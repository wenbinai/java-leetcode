package zhuanti.linklist._001;

import leetcode.solution.structure.ListNode;

public class Solution {
    /**
     * 给定两个有序链表的头指针head1和head2
     * 打印两个链表的公共部分
     *
     * @param head1
     * @param head2
     */
    /**
     * 主要思路:
     *
     * @param head1
     * @param head2
     */
    public void printCommonPart(ListNode head1, ListNode head2) {
//        if(head1 == null || head2 == null) {
//            return;
//        }
        while (head1 != null && head2 != null) {
            if(head1.val == head2.val) {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
            if(head1.val < head2.val) {
                head1 = head1.next;
            }
            if(head1.val > head2.val) {
                head2 = head2.next;
            }
        }
    }
    public static void main(String[] args) {

    }
}
