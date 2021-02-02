package leetcode.solution.easy._0067;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char)(carry % 2 + '0'));
            carry >>= 1;
        }

        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char)(carry % 2 + '0'));
            carry >>= 1;
        }

        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char)(carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
