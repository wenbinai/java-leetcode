package leetcode.solution.easy._0069;

public class Solution {
    public int mySqrt(int x) {
         /*
            0 - x 之间 a >= x / a
            注意: 考虑 r + 1 溢出的情况
        */
        long l = 0, r = x;
        while (l < r) {
            long mid = (l + (r - l + 1) / 2);
            if (check(mid, x)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return (int) l;
    }

    private boolean check(long mid, int x) {
        if (mid > x / mid) {
            return true;
        }

        return false;
    }

}
