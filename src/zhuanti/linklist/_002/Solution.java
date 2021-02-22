package zhuanti.linklist._002;

import leetcode.solution.structure.ListNode;

import javax.swing.*;

public class Solution {
    /**
     * 分别实现两个函数,
     * 一个可以删除单链表中倒数第k个节点
     * 一个可以删除双链表中倒数第k个节点
     */
    /**
     * 主要思路:
     * 1 2 3 4 5
     * k = 3
     * 2 1 0 -1 -2
     * k = 2
     * 1 0 -1 -2 -3
     *
     * @param head
     * @param lastKth
     * @return
     */
    public ListNode removeLastKthNode(ListNode head, int lastKth) {
        // 注意: 特判k的范围啥的
        if(head == null || lastKth < 1) return head;
        ListNode tmp = head;
        while (tmp != null) {
            lastKth --;
            tmp = tmp.next;
        }
        // 头节点: 移除头节点
        if(lastKth == 0) {
            head = head.next;
        }
        // 移除一般节点
        if(lastKth < 0) {
            tmp = head;
            while (++lastKth != 0) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
        return head;

    }
}
