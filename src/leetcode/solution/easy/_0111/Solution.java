package leetcode.solution.easy._0111;

import leetcode.solution.structure.TreeNode;

public class Solution {
    /**
     * 给定二叉树, 求其最小深度
     * 最小深度: 根节点到最近叶子节点最短路径上的节点数量
     * 叶子节点: 没有子节点的节点
     * <p>
     * 思路: 利用递归
     * 左子树, 右子树 最小深度的最小值
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l != 0 && r != 0)
            return 1 + Math.min(l, r);
        return 1 + l + r;
    }
}
