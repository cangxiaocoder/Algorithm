package com.cangxiao.leetCode.easy;

import java.util.Stack;

/**
 * @Author cangxiao
 * @Date 2021/10/19
 * @Desc 98. 验证二叉搜索树
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /**
     * 左子树的最大值要小于根节点，左子树的最大值为左子树的最右节点
     * 右子树的最小值要大于根节点，右子树的最小值为右子树的最左节点
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean check(TreeNode root, long minValue, long maxValue) {
        if (root==null) return true;
        if (minValue >= root.val || root.val>=maxValue){
            return false;
        }
        return check(root.left,minValue,root.val) && check(root.right,root.val,maxValue);
    }

    /**
     * 中序遍历， 如果后面节点的值大于等于前面节点的值，则不是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorder  = Long.MIN_VALUE;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val<inorder ){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
