package com.cangxiao.leetCode.easy;

import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2021/10/17
 * @Desc 559. N 叉树的最大深度
 */
public class Solution559 {

    public int maxDepth2(Node root) {
        int depth = 0;
        if (root==null) return depth;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            //size 即为每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                queue.addAll(node.children);
            }
        }
        return depth;
    }

    public int maxDepth(Node root) {
        int depth = 0;
        if (root==null) {
            return depth;
        }else {
            int max = 0;
            for (Node child : root.children) {
                max = Math.max(max,maxDepth(child));
            }
            depth = max + 1;
        }
        return depth;
    }
}
