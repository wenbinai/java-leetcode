package leetcode.solution.easy._0070;

public class Solution {
    /**
     * 注意: 利用递归实现会超时
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            b += a;
            a = b - a;
        }

        return b;
    }
}
