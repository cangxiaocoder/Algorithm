package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/10/19
 * @Desc 101. 对称二叉树
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return check(root.left,root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false;

        return p.val==q.val && check(p.left,q.right) & check(p.right,q.left);
    }

}
