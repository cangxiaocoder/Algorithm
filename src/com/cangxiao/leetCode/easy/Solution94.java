package com.cangxiao.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/12
 * @Desc 94. 二叉树的中序遍历
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        print(root, result);
        return result;
    }
    private void print(TreeNode node, List<Integer> result){
        if (node!=null){
            print(node.left, result);
            result.add(node.val);
            print(node.right, result);
        }
    }

}
