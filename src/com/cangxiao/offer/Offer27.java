package com.cangxiao.offer;

import com.cangxiao.offer.common.TreeNode;

/**
 * @Author cangxiao
 * @Date 2022/3/26
 * @Desc 剑指 Offer 27. 二叉树的镜像
 */
public class Offer27 {

    /**
     * 创建新的TreeNode
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode treeNode = new TreeNode(root.val);
        print(root, treeNode);
        return treeNode;
    }

    private void print(TreeNode node, TreeNode treeNode) {
        if (node == null) return;
        if (node.left != null) {
            treeNode.right = new TreeNode(node.left.val);
            print(node.left, treeNode.right);
        }
        if (node.right != null) {
            treeNode.left = new TreeNode(node.right.val);
            print(node.right, treeNode.left);
        }
    }

    /**
     * 在原二叉树上改动
     * 根节点不变
     * 左子树等于原右子树
     * 右子树等于原左子树
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        Offer27 offer27 = new Offer27();
        TreeNode treeNode = offer27.mirrorTree(A);
        System.out.println("treeNode = " + treeNode);
    }
}
