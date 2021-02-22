package leetcode.solution.medium._0103;

import leetcode.solution.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (count % 2 == 0) {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                } else {
                    if (node.right != null)
                        queue.add(node.right);
                    if (node.left != null)
                        queue.add(node.left);
                }
            }
            count++;
            res.add(level);
        }
        return res;
    }
}
