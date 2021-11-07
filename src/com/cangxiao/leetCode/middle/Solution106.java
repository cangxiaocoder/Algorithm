package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/7
 * @Desc 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int p, int r) {
        if (i > j) return null;
        //后序遍历最后一个为个根节点
        TreeNode root = new TreeNode(postorder[r]);
        int k = i;
        //找到中序遍历的根节点
        while (k <= j &&  inorder[k] != postorder[r]) {
            k++;
        }
        //中序遍历前面为左子树， 计算左子树大小
        int leftSize = k - i;
        /*
            后序遍历：
                r 为根节点，p到p + leftSize - 1是左子树，减1是去除根节点
                r 为根节点，p + leftSize到r-1是右子树，减1是去除根节点
            中序遍历：
                k 为根节点，i到k-1是左子树
                k 为根节点，k+1到j是右子树
         */
        TreeNode leftTree = buildTree(inorder, i, k - 1, postorder, p, p + leftSize - 1);
        TreeNode rightTree = buildTree(inorder, k + 1, j, postorder, p + leftSize, r - 1);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
