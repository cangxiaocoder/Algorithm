package com.cangxiao.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/23
 * @Desc 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class SolutionOffer54 {
    /**
     * 中序遍历，按顺序排列找到最大值的索引
     */
    List<Integer> list = new ArrayList<>();
    public int kthLargest2(TreeNode root, int k) {
        print2(root);
        return list.get(list.size()-k);
    }

    private void print2(TreeNode node){
        if (node!=null){
            print2(node.left);
            list.add(node.val);
            print2(node.right);
        }
    }

    int result = -1;
    int k = 0;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        if (node!=null){
            dfs(node.right);
            if (k==0)return ;
            if (--k==0) result = node.val;
            dfs(node.left);
        }
    }
}
