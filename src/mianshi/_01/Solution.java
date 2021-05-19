package mianshi._01;


public class Solution {
    public static void main(String[] args) {
    }

    /**
     * 1、已知一个字符串都是由左括号(和右括号)组成，
     * 判断该字符串是否是有效的括号组合。
     * <p>
     * 例子：()(),(()),(()())
     * 有效的括号组合:
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
     * <p>
     * for i len-1
     * if char i == )
     * pre = i - dp[i-1] - 1
     * if pre >= 0 pre == (
     * dp[i] = dp[i-1]+2+(pre>0 dp[pre-1] : 0)
     *
     * @param str
     * @return
     */
    public static int maxLength(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chars = str.toCharArray();
        // Java 里面默认初始化为0
        int[] dp = new int[chars.length];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//        动态规划
////        怎么定义dp[i]？
////        我们试着拆分子问题，目光盯着子问题与大问题之间的联系
////“提供” 这词我比较喜欢用：前一个子问题的解可以“提供”给后一个子问题多大的有效长度。后一个子问题的最优解，要想纳入前面“提供”的有效长度，则前面子串的末尾必须是有效子串的一部分。
////        子问题dp[i]定义为：以s[i]为结尾的子串中，形成的最长有效子串的长度，且有效子串是以s[i]为结尾。
////        有效子串是以s[i]为结尾，这样才能“提供”给后一个子问题一段有效长度
////                紧盯子问题与大问题之间的联结点
////        我们注意子串的末位s[i]，它要么是'('，要么是')'：
////
////        s[i]是'('，以它为结尾的子串，肯定不是有效括号子串——dp[i] = 0
////        s[i]是')'，以它为结尾的子串，有可能是有效子串，还需考察前一个子问题的末尾：s[i-1]
////        s[i-1]是'('，s[i-1]和s[i]组成一对，有效长度保底为 2，还需考察s[i-2]：
////        s[i-2]不存在，则有效长度只有 2——dp[i] = 2
////        s[i-2]存在，则加上以s[i-2]为结尾的最长有效长度——dp[i] = dp[i-2]+2
////        s[i-1]是')'，s[i-1]和s[i]就是'))'，以s[i-1]为结尾的最长有效长度为dp[i-1]，跨过这个长度（具体细节不用管，总之它最大能提供dp[i-1]长度），来看s[i-dp[i-1]-1]这个字符：
////        s[i-dp[i-1]-1]不存在或为')'，则s[i]找不到匹配，直接gg——dp[i]=0
////        s[i-dp[i-1]-1]是'('，与s[i]匹配，有效长度 = 2 + 跨过的dp[i-1]+ 前方的dp[i-dp[i-1]-2]。等一下，s[i-dp[i-1]-2]要存在才行！：
////        s[i-dp[i-1]-2]存在，dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
////        s[i-dp[i-1]-2]不存在，dp[i] = dp[i-1] + 2
////        base case ：dp[0] = 0 一个括号形成不了有效子串
////        DP 代码
////        时间复杂度和空间复杂度都是 O(n)O(n)
////
////
////const longestValidParentheses = (s) => {
////            let maxLen = 0;
////  const len = s.length;
////  const dp = new Array(len).fill(0);
////            for (let i = 1; i < len; i++) {
////                if (s[i] == ')') {
////                    if (s[i - 1] == '(') {
////                        if (i - 2 >= 0) {
////                            dp[i] = dp[i - 2] + 2;
////                        } else {
////                            dp[i] = 2;
////                        }
////                    } else if (s[i - dp[i - 1] - 1] == '(') {
////                        if (i - dp[i - 1] - 2 >= 0) {
////                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
////                        } else {
////                            dp[i] = dp[i - 1] + 2;
////                        }
////                    }
////                }
////                maxLen = Math.max(maxLen, dp[i]);
////            }
////            return maxLen;
////        };
////         }
////}

