package com.cangxiao.leetCode.middle;

import com.cangxiao.leetCode.middle.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/16
 * @Desc 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class Offer32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        List<Integer> resultList= new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            resultList.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
