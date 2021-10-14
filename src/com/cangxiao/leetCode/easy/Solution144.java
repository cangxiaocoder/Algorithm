package com.cangxiao.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/12
 * @Desc 144. 二叉树的前序遍历
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        print(root, result);
        return result;
    }

    private void print(TreeNode node, List<Integer> result){
        if (node!=null){
            result.add(node.val);
            print(node.left, result);
            print(node.right, result);
        }
    }

}
