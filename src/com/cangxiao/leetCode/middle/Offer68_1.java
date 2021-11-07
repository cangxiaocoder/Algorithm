package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/2
 * @Desc 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class Offer68_1 {

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        if (result != null) return 2;
        //左子树包含p/q的个数
        int leftContains = dfs(root.left, p, q);
        //右子树包含p/q的个数
        int rightContains = dfs(root.right, p, q);

        int rootContains = 0;
        if (root == p || root == q) {
            rootContains = 1;
        }
        if (rootContains == 0 && (leftContains == 1 && rightContains == 1)) {
            result = root;
        }
        if (rootContains == 1 && (leftContains == 1 || rightContains == 1)) {
            result = root;
        }
        return rootContains + leftContains + rightContains;
    }

    private int dfs2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        if (result != null) return 2;
        int leftContains = 0;
        int rightContains = 0;
        if (root.val >= p.val && root.val >= q.val) {
            //左子树包含p/q的个数
            leftContains = dfs(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            //右子树包含p/q的个数
            rightContains = dfs(root.right, p, q);
        } else {
            //左子树包含p/q的个数
            leftContains = dfs(root.left, p, q);
            //右子树包含p/q的个数
            rightContains = dfs(root.right, p, q);
        }

        int rootContains = 0;
        if (root == p || root == q) {
            rootContains = 1;
        }
        if (rootContains == 0 && (leftContains == 1 && rightContains == 1)) {
            result = root;
        }
        if (rootContains == 1 && (leftContains == 1 || rightContains == 1)) {
            result = root;
        }
        return rootContains + leftContains + rightContains;
    }

    private void dfs3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return ;
        //当p/q一个在root节点的左边一个在右边，则root是他们的最近公共祖先
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
            result = root;
        }
        if (result != null) return;
        if (root.val >= p.val) {
            //左子树包含p/q的个数
           dfs(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            //右子树包含p/q的个数
            dfs(root.right, p, q);
        }
    }
}
