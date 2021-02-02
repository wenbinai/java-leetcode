package leetcode.solution.easy._0035;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        // 在排序数组中找到第一个 >= target 的数
        int len = nums.length;
        // 特例
        if (nums[len - 1] < target) return len;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(nums[mid], target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int value, int target) {
        if (value >= target) {
            return true;
        }
        return false;
    }
}
