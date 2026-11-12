package com.cangxiao.search;

import com.cangxiao.common.TreeNode;

/**
 * @Author: cangxiao
 * @Since: 12/11/2026
 * @description: 105. 从前序与中序遍历序列构造二叉树
 */
public class StrutBinTree105 {

    public static void main(String[] args) {
        StrutBinTree105 strutBinTree = new StrutBinTree105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = strutBinTree.buildTree(preorder, inorder);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int l, int r) {
        if (i > j) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[i]);
        int k = l;
        while (k <= r && node.val != inorder[k]) {
            k++;
        }
        int leftSize = k - i;
        /*
            前序遍历：
                i 为根节点，i+1到i+leftTreeSize是左子树
                i 为根节点，i+leftTreeSize+1到j是右子树
            中序遍历：
                k 为根节点，l到k-1是左子树
                k 为根节点，k+1到r是右子树
         */
        TreeNode leftNode = buildTree(preorder, i + 1, i + leftSize, inorder, k, k - 1);
        TreeNode rightNode = buildTree(preorder, i + leftSize + 1, j, inorder, k + 1, r);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
