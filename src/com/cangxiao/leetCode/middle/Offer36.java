package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/6
 * @Desc 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class Offer36 {

    TreeNode head = new TreeNode();
    TreeNode tail = head;

    /**
     * right指针为next指针
     * left指针为pre指针
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root==null) return null;
        inorder(root);
        head.right.left = tail;
        tail.right = head.right;
        return head.right;
    }

    /**
     * 中序遍历保持有序
     * @param root
     */
    private void inorder(TreeNode root){
        if (root==null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        inorder(left);
        //tail节点为前一个节点，right指针指向当前节点
        tail.right = root;
        //当前节点的left指针指向前一个节点
        root.left = tail;
        //移动tail到当前节点
        tail = root;
        inorder(right);
    }
}
