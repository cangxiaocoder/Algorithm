package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/9
 * @Desc 437. 路径总和 III
 */
public class Solution437 {

    public int pathSum(TreeNode root, int targetSum) {

        if (root==null) return 0;
        int result = rootSum(root, targetSum);
        result += pathSum(root.left,targetSum);
        result += pathSum(root.right,targetSum);
        return result;
    }

    private int rootSum(TreeNode root, int targetSum) {
        int result = 0;
        if (root==null) return result;
        //如果当前节点和目标值相同，则路径条数+1；
        if (root.val == targetSum){
            result++;
        }
        /*
            若当前节点和目标值相同， 则向下搜索找到和为0的路径；
            若当前节点和目标值不相同， 则向下搜索找到和为目标值与当前节点值差值的路径；
         */
        result+=rootSum(root.left, targetSum - root.val);
        result+=rootSum(root.right, targetSum - root.val);
        return result;
    }
}
 