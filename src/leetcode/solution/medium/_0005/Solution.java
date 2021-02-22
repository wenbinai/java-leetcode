package leetcode.solution.medium._0005;

public class Solution {
    int st, end;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 1) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            helper(chars, i, i);
            helper(chars, i, i + 1);
        }

        return s.substring(st, end + 1);
    }

    private void helper(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }

        if (end - st < r - l - 2) {
            st = l + 1;
            end = r -1;
        }
    }
}
