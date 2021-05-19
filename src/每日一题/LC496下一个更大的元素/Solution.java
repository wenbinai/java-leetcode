package 每日一题.LC496下一个更大的元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int val = stack.pop();
                int maxVal = nums2[i];
                map.put(val, maxVal);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
