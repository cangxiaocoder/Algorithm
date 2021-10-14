package com.cangxiao.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/12
 * @Desc 145. 二叉树的后序遍历
 */
public class Solution145 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        print(root, result);
        return result;
    }
    private void print(TreeNode node, List<Integer> result){
        if (node!=null){
            print(node.left, result);
            print(node.right, result);
            result.add(node.val);
        }
    }
}
