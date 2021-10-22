package com.cangxiao.leetCode.easy;

import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2021/10/17
 * @Desc 104. 二叉树的最大深度
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root==null) return depth;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            //size 即为每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        int depth = 0;
        if (root==null) {
            return 0;
        }else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            depth = Math.max(leftHeight,rightHeight) + 1;
        }
        return depth;
    }
}
