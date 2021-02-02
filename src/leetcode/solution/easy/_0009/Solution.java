package leetcode.solution.easy._0009;

public class Solution {
    /**
     * 主要思路:
     * 1. 借鉴0007中反转数字
     * 将数字反转后进行对比
     * 2. 借用字符串
     * 3. 优化: 反转一半的数字
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // 特例:
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }

        return halfReverseX == x || halfReverseX / 10 == x;
    }

}
