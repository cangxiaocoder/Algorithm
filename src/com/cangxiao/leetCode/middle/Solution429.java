package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/16
 * @Desc 429. N 叉树的层序遍历
 */
public class Solution429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return  result;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(level);
        }
        return result;
    }
}
