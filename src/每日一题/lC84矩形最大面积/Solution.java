package 每日一题.lC84矩形最大面积;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * 暴力:
     * 可以遍历每根柱子，以当前柱子 i 的高度作为矩形的高，
     * 那么矩形的宽度边界即为向左找到第一个高度小于当前柱体 i 的柱体，
     * 向右找到第一个高度小于当前柱体 i 的柱体。
     * 对于每个柱子我们都如上计算一遍以当前柱子作为高的矩形面积，最终比较出最大的矩形面积即可
     * <p>
     * 时间复杂度: O(N^2)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            int w = 1, h = heights[i], j = i;
            if (h * n <= area) continue;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }

        return area;
    }

    /**
     * 利用单调栈快速求出边界
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea01(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int area = 0;
        int[] tmp = new int[n + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                int w = i - stack.peek() - 1;
                area = Math.max(area, w * h);
            }
            stack.push(i);
        }
        return area;
    }
}
