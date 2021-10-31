package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/10/23
 * @Desc 538. 把二叉搜索树转换为累加树
 */
public class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    int sum = 0;
    private void dfs(TreeNode node){
        if (node!=null){
            dfs(node.right);
            sum += node.val;
            node.val = sum;
            dfs(node.left);
        }
    }
}
