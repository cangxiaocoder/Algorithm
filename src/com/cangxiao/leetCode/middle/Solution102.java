package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/16
 * @Desc 102. 二叉树的层序遍历
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()){
                queue2.offer(queue.poll());
            }
            while (!queue2.isEmpty()){
                TreeNode node = queue2.poll();
                temp.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }

        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            //size 即为每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
