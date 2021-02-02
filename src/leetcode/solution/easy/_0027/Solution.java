package leetcode.solution.easy._0027;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }

        return tail;
    }
}
