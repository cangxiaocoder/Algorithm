package com.cangxiao.leetCode.hard;

import com.sun.deploy.security.ValidationState;

/**
 * @Author cangxiao
 * @Date 2021/11/8
 * @Desc 124. 二叉树中的最大路径和
 */
public class Solution124 {

    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root==null) return 0;
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);

        int max = root.val;
        if(leftPath > 0)max+=leftPath;
        if(rightPath > 0)max+=rightPath;
        if (max > result) result = max;

        int val = root.val;
        if (val < leftPath + val) val +=leftPath;
        if (val < rightPath + val) val += rightPath;
        return val;
    }

    private int dfs2(TreeNode root) {
        if (root==null) return 0;
        //只有左右节点的值大于0才选择当前节点，
        int leftMax = Math.max(dfs(root.left),0);
        int rightMax = Math.max(dfs(root.right),0);
        result = Math.max(result,root.val + leftMax+rightMax);

        return root.val + Math.max(leftMax,rightMax);
    }
}
