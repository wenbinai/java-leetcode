package zhuanti.linklist._003;

import leetcode.solution.structure.ListNode;

public class Solution {
    /**
     * 反转单链表和双链表
     */
    /**
     * 主要思路:
     * 特判: 如果head == null || head.next == null
     *      return head
     * 一般情况:
     * 1 -> 2 -> 3 -> null
     * 1 <- 2 <- 3
     * 初始化
     * cur=head pre next
     *
     * next = cur.next
     * cur.next = pre
     * pre = cur
     * cur = next
     */
    // 反转单链表 利用头插法解决
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        // 头插法
        while (head != null) {
            // 先保留next节点
            next = head.next;
            // 头插法
            head.next = pre;
            pre = head;
            // 更新头节点
            head = next;
        }
        return pre;
    }
    // 反转单链表 就地置换法
    public static ListNode reverse2(ListNode head) {
        ListNode pre = head, next = null;
        while (head != null) {
            next = head.next;
            if (next != null)
                head.next = next.next;
            else return pre;
            next.next = pre;
            pre = next;
        }
        return pre;
    }
    // 反转双链表 头插法
    public static ListNode2 reverse(ListNode2 head) {
        ListNode2 pre = null, next = null;
        while (head != null) {
            // 保留下个节点信息
            next = head.next;
            // 利用头插法
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
class ListNode2 {
    public int val;
    public ListNode2 last;
    public ListNode2 next;
    public ListNode2(int val) {
        this.val = val;
    }
}

