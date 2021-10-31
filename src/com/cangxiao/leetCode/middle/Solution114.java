package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/10/24
 * @Desc 114. 二叉树展开为链表
 */
public class Solution114 {
    TreeNode head = new TreeNode();
    TreeNode tail = head;
    public void flatten(TreeNode root) {
        dfs(root);
        root = head.right;
    }

    private void dfs(TreeNode root) {
        if (root==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        tail.left = null;
        tail.right = root;
        tail = root;
        dfs(left);
        dfs(right);
    }
}
