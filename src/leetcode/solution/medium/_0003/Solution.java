package leetcode.solution.medium._0003;

public class Solution {
    /**
     * 注意: 简单区子串和子序列的区别
     * pwwkew中 pwke不是子串, 而是子序列
     * 经典问题:
     * 求最长子序列?
     * 求最长不重复的子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || s.length() == 0) return 0;
        len = s.length();
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int l = i - preP + 1;
            hash[c] = i + 1;
            if (l > max) max = l;
        }

        return max;
    }
}
