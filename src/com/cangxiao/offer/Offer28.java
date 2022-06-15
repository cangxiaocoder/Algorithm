package com.cangxiao.offer;

import com.cangxiao.offer.common.TreeNode;

/**
 * @Author cangxiao
 * @Date 2022/3/26
 * @Desc 剑指 Offer 28. 对称的二叉树
 */
public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right){
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        return left.val == right.val && recur(left.left,right.right)&&recur(left.right,right.left);
    }
}
