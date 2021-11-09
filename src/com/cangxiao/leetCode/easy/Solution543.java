package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/11/7
 * @Desc 543. 二叉树的直径
 */
public class Solution543 {

    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return result;
    }

    private int diameter(TreeNode root){
        if (root==null) return 0;
        int maxLeft = diameter(root.left);
        int maxRight = diameter(root.right);
        //最大直径 = 左便最大直径 + 右边最大直径
        int diameter = maxLeft + maxRight;
        if (diameter>result) result = diameter;
        //选择左右子树直径更大的一边然后加上根节点
        return Math.max(maxLeft , maxRight) + 1;
    }
}
