package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/10/23
 * @Desc 面试题 04.06. 后继者
 */
public class Interview04_06 {

    TreeNode result = null;
    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);
        return result;
    }

    private void dfs(TreeNode node, TreeNode p){
        if (node==null) return;
        dfs(node.left,p);
        if (flag){
            result = node;
            flag = false;
            return;
        }
        //当flag == true时，即找到了P这个节点，然后再中序遍历一次，就找到了当前节点的下一个节点
        if (node==p) flag = true;
        dfs(node.right,p);
    }
}
