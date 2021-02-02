package leetcode.solution.easy._0007;

public class Solution {
    /**
     * 主要思路:
     * 123
     * 每次 % 10
     * 3 2 1
     * 注意: 可能会造成溢出
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
}
