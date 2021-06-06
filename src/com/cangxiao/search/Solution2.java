package com.cangxiao.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2021/4/14
 * LeetCode 783. 二叉搜索树节点最小距离
 * @Desc 二叉搜索树有个性质为二叉搜索树中序遍历得到的值序列是递增有序的
 */
public class Solution2 {
    int min = Integer.MAX_VALUE;
    int pre =-1; //前一个节点
    public int minDiffInBST(TreeNode treeNode) {
        Queue<TreeNode> search = new ArrayDeque<>();

        if(treeNode==null){
            return min;
        }
        mid(treeNode);
        return min;
    }

    /**
     * 中序遍历,输出的值是递增的
     * @param treeNode
     * @return
     */
    public void mid(TreeNode treeNode){
        if(treeNode==null){
            return ;
        }
        mid(treeNode.left);
        //输出最左侧的值,输出的pre从小到大排列
        System.out.println("pre = " + pre);
        if(pre==-1){
            //pre==-1,此时输出的为最左侧的第一个节点，将第一个节点赋值给pre;
            pre=treeNode.val;
        }else {
            //将当前节点减去前一个节点得到差值，然后与当前最小差值比较，得到最小差值
            min = Math.min(min,treeNode.val-pre);
            //将当前节点赋值给pre,成为下次比较的前一个节点；
            pre = treeNode.val;
        }
        mid2(treeNode.right);
    }
    /**
     * 中序遍历,输出的值是递增的
     * @param treeNode
     * @return
     */
    public void mid2(TreeNode treeNode){
        if(treeNode==null){
            return ;
        }
        mid(treeNode.left);
        //输出最左侧的值,输出的pre从小到大排列
        System.out.println("pre = " + pre);
        if(pre!=-1){
            //pre==-1,此时输出的为最左侧的第一个节点，将第一个节点赋值给pre;
            //将当前节点减去前一个节点得到差值，然后与当前最小差值比较，得到最小差值
            min = Math.min(min,treeNode.val-pre);
            //将当前节点赋值给pre,成为下次比较的前一个节点；
        }

        pre=treeNode.val;
        mid(treeNode.right);
    }
}
