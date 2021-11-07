package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/6
 * @Desc 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int p, int r) {
        if (i > j) return null;
        TreeNode root = new TreeNode(preorder[i]);
        int q = p;
        //遍历中序遍历数组， 相等时q即为中序遍历的根节点
        while (q <= r && inorder[q] != preorder[i]) {
            q++;
        }
        int leftTreeSize = q - p;
        /*
            前序遍历：
                i 为根节点，i+1到i+leftTreeSize是左子树
                i 为根节点，i+leftTreeSize+1到j是右子树
            中序遍历：
                q 为根节点，p到q-1是左子树
                q 为根节点，q+1到r是右子树
         */
        TreeNode leftTree = buildTree(preorder, i + 1, i + leftTreeSize, inorder, p, q - 1);
        TreeNode rightTree = buildTree(preorder, i + leftTreeSize + 1, j, inorder, q + 1, r);

        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
