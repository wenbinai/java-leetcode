package mianshi.linklist;

import leetcode.solution.structure.ListNode;

import java.util.Stack;

/**
 * 判断链表是否为回文
 */
public class HuiWen {
    //O(n)的空间复杂度
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // O(n/2) 的时间复杂度
//    public static boolean isPalindrome1(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode right = head.next;
//        ListNode cur = head;
//        while (cur.next != null && cur.next.next != null) {
//            right = right.next;
//            cur = cur.next.next;
//        }
//        Stack<ListNode> stack = new Stack<>();
//        while (right != null) {
//            stack.push(right);
//        }
//        right = right.next;
//    }

    public static void main(String[] args) {

    }
}
