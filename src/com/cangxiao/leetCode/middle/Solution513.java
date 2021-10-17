package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/16
 * @Desc 513. 找树左下角的值
 */
public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        int result = -1;
        if (root==null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //size 即为每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //i==0 即为最左侧的节点
                if (i==0) result = node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
