package com.cangxiao.leetCode.middle;

import java.time.OffsetDateTime;

/**
 * 如果x是p和q的最近公共祖先
 * 1。x不为p或q: 则x的左子树和右子树只包含p或q中的一个
 * 2. x为p或q: 则x的左子树和右子树只有其中一个子树包含p或q
 * @Author cangxiao
 * @Date 2021/10/24
 * @Desc 236. 二叉树的最近公共祖先
 */
public class Solution236 {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p , q);
        return result;
    }
    private int dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return 0;
        //左子树包含p和q的个数
        //result不为空， 说明已经找到最近共祖先，
        if (result!=null) return 2;
        int leftContains = dfs(root.left,p,q);
        int rightContains = dfs(root.right,p,q);
        //x为最近公共祖先，而且x为p或q;
        int rootContains = 0;
        if (root==p || root==q){
            rootContains = 1;
        }
        //rootContains为0， 左右子树各有一个p或q, 则当前节点即为p、q的最近公共祖先
        if (rootContains==0 && (leftContains==1 && rightContains==1)){
            result = root;
        }
        //rootContains为1，说明当前节点即为p或q中的一个，其左右子树只要有一个子树包含p获q则当前节点为最近公共祖先
        if (rootContains==1 && (leftContains==1 || rightContains==1)){
            result = root;
        }
        //返回当前子树包含多少个p或q
        return leftContains+rightContains+rootContains;
    }
}
