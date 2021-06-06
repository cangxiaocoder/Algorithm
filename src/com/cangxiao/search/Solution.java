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
public class Solution {

    public int minDiffInBST(TreeNode treeNode) {
        Queue<TreeNode> search = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        if(treeNode==null){
            return min;
        }
        List<Integer> list = mid(treeNode);
        System.out.println("list = " + list);
        for (int i = list.size() - 1; i >= 1; i--) {
            min = Math.min(min,(list.get(i)-list.get(i-1)));
        }
        return min;
    }

    /**
     * 中序遍历
     * @param treeNode
     * @return
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> mid(TreeNode treeNode){

        if(treeNode!=null){
            mid(treeNode.left);
            list.add(treeNode.val);
            mid(treeNode.right);
        }
        return list;
    }
}
