package com.cangxiao.leetCode.code173;

import java.util.Stack;

/**
 * leetCode 173题
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。
 * 指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * @Author cangxiao
 * @Date 2021/8/3
 * @Desc 剑指 Offer II 055. 二叉搜索树迭代器
 *
 *
 *
 */
public class BSTIterator2 {

    private Stack<TreeNode> nodeStack;
    private TreeNode currentNode;
    public BSTIterator2(TreeNode root) {
        currentNode = root;
        nodeStack = new Stack<>();

    }

    public int next() {
        while (currentNode!=null){
            nodeStack.push(currentNode);
            currentNode = currentNode.left;
        }
        currentNode = nodeStack.pop();
        int value = currentNode.val;
        currentNode = currentNode.right;
        return value;
    }

    public boolean hasNext() {
        return currentNode==null && nodeStack.isEmpty();
    }



    public static void main(String[] args) {

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
