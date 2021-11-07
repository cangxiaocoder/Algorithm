package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/7
 * @Desc 889. 根据前序和后序遍历构造二叉树
 */
public class Solution889 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int i, int j, int[] postorder, int p, int r) {
        if (i > j) return null;
        TreeNode root = new TreeNode(preorder[i]);
        //当i==j时只有一个根节点
        if (i == j) return root;
        int q = p;
        //前序遍历，跟节点之后的第一个节点时左子树， 后序遍历第一个即为左子树
        while (q <= r && postorder[q] != preorder[i + 1]) {
            q++;
        }
        int leftSize = q - p + 1;
        /*
            前序遍历：
                i 为根节点，i+1到i+leftTreeSize是左子树
                i 为根节点，i+leftTreeSize+1到j是右子树
            中序遍历：
                r 为根节点，p到q是左子树
                r 为根节点，q+1到r-1是右子树
         */
        TreeNode leftTree = buildTree(preorder, i + 1, i + leftSize, postorder, p, q);
        TreeNode rightTree = buildTree(preorder, i + leftSize + 1, j, postorder, q + 1, r - 1);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
