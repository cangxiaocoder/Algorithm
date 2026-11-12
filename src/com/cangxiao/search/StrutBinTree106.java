package com.cangxiao.search;

import com.cangxiao.common.TreeNode;

/**
 * @Author: cangxiao
 * @Since: 12/11/2026
 * @description: 105. 从前序与中序遍历序列构造二叉树
 */
public class StrutBinTree106 {

    public static void main(String[] args) {
        StrutBinTree106 strutBinTree = new StrutBinTree106();
        int[] postorder = {-1};
        int[] inorder = {-1};
        TreeNode treeNode = strutBinTree.buildTree(inorder, postorder);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int l, int r) {
        if (i > j) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[r]);
        int k = i;
        while (k <= j && node.val != inorder[k]) {
            k++;
        }
        int leftSize = k - i;
        /*
         *  中序遍历：
         *   k为根节点，k+1 ~ j 为右节点
         *   k为根节点，i ~ k - 1 为作节点
         *  后序遍历：
         *    r为根节点, l + leftSize ~ r - 1为右节点, 减1去除根节点
         *    r为根节点, l ~ l + leftSize - 1为左节点, 减1去除根节点
         * */
        TreeNode leftNode = buildTree(inorder, i, k - 1, postorder, l, l + leftSize - 1);
        TreeNode rightNode = buildTree(inorder, k + 1, j, postorder, l + leftSize, r - 1);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
