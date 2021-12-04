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
        while (root!=null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    private void dfs(TreeNode root) {
        if (root==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        tail.left = null;
        tail.right = root;
        tail = root;
        dfs(root.left);
        dfs(right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,new TreeNode(5,new TreeNode(4),new TreeNode(3)),new TreeNode(1));
        Solution114 solution114 = new Solution114();
        solution114.flatten(root);
    }
}
