package leetcode.solution.easy._0014;

public class Solution {
    /**
     * 主要思路: 先获取字符数组中的最小长度
     * 在遍历所有数组中最小相等长度
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        for (int j = 0; j < minLen; j++) {
            for (int i = 1; i < len; i++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
