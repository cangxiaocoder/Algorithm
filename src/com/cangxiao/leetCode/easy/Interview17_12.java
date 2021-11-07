package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/11/4
 * @Desc 面试题 17.12. BiNode
 */
public class Interview17_12 {
    TreeNode head = new TreeNode();
    TreeNode tail = head;
    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        return head.right;
    }

    private void dfs(TreeNode root) {
        if (root==null) return;
        dfs(root.left);
        tail.right = root;
        tail = root;
        tail.left = null;
        dfs(root.right);
    }

}
