package leetcode.solution.medium._0011;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0, h = 0;
        while (l < r) {
            h = Math.min(height[l], height[r]);
            max = Math.max(max, (r - l) * h);
            while (height[l] <= h && l < r) l++;
            while (height[r] <= h && l < r) r--;
        }
        return max;
    }
}
