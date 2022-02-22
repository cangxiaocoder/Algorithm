package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/2/22
 * @Desc 剑指 Offer 07. 重建二叉树
 * 前序遍历 根节点 - 左子树 - 右子树
 * 中序遍历 左子树 - 根节点 - 右子树
 */
public class Offer07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int p, int r) {
        if (i > j) return null;
        //前序遍历第一个元素为根节点
        TreeNode root = new TreeNode(preorder[i]);
        int q = p;
        //找到中序遍历的根节点，p到q之间为左子树
        while (q <= r && preorder[i] != inorder[q]) {
            q++;
        }
        int leftSize = q - p;
        TreeNode leftNode = buildTree(preorder,i+1, i+leftSize,inorder, p, q-1);
        TreeNode rightNode = buildTree(preorder,i+leftSize+1, j,inorder, q+1, r);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}