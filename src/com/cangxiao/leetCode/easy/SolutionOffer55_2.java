package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/10/17
 * @Desc 剑指 Offer 55 - II. 平衡二叉树
 */
public class SolutionOffer55_2 {

    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
            return isBalanced2(root.left) && isBalanced2(root.right);
        }
        return false;
    }


    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            depth = Math.max(leftHeight, rightHeight) + 1;
        }
        return depth;
    }

    /**
     * 方法一由于是自顶向下递归，因此对于同一个节点，函数 height 会被重复调用，
     * 导致时间复杂度较高。如果使用自底向上的做法，则对于每个节点，函数 height 只会被调用一次。
     * <p>
     * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，
     * 再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），
     * 否则返回 −1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
     */
    public boolean isBalanced(TreeNode root) {
        return height(root)>1;
    }

    public int height(TreeNode root){
        if (root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // 如果leftHeight ==-1 或者 rightHeight == -1 说明有某棵子树是非平衡二叉树，所以直接返回-1
        if (leftHeight==-1 || rightHeight==-1 || Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
