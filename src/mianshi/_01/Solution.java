package mianshi._01;


public class Solution {
    public static void main(String[] args) {
    }

    /**
     * 1、已知一个字符串都是由左括号(和右括号)组成，
     * 判断该字符串是否是有效的括号组合。
     * <p>
     * 例子：
     * 有效的括号组合:()(),(()),(()())
     * 无效的括号组合:(,()),((),()(()
     */
    /**
     * 主要思路:
     * 1. 特判
     * 2. 判断是否有其他无关字符等
     * 3. count if ( ++
     * if ) --
     * if count < 0 false
     * 最后判断是否等于 count
     * 理由: 成对出现的
     *
     * @param str
     * @return
     */
    public static boolean isValid(String str) {
        // 一定记得需要特判
        if (str == null || str.equals("")) return false;
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ')' && chars[i] != '(')
                return false;
            if (chars[i] == '(')
                count++;
            if (chars[i] == ')' && --count < 0)
                return false;
        }
        return count == 0;
    }

    /**
     * 已知一个字符串都是由左括号(和右括号)组成，
     * 返回最长有效括号子串的长度。
     */
    /**
     * 主要思路:
     * 1. 特判: str 0 ""
     * 2. 求出递推方程
     * 3. dp[i-1]
     *
     * for i len-1
     *  if char i == )
     *      pre = i - dp[i-1] - 1
     *      if pre >= 0 pre == (
     *          dp[i] = dp[i-1]+2+(pre>0 dp[pre-1] : 0)
     *
     * @param str
     * @return
     */
    public static int maxLength(String str) {
        if(str == null || str.equals("")) return 0;
        char[] chars = str.toCharArray();
        // Java 里面默认初始化为0
        int[] dp = new int[chars.length];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ')') {
                pre = i - dp[i-1] - 1;
                if(pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
