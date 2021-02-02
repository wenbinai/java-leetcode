package leetcode.solution.easy._0110;

import leetcode.solution.structure.TreeNode;

public class Solution {
    /**
     * 判断一棵树是否是平衡二叉树
     * 每个节点的左右子树高度差的绝对值 <= 1
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        if (l == -1) return -1;
        int r = helper(node.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }

}
