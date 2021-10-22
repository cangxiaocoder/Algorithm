package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/10/19
 * @Desc 226. 翻转二叉树
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
