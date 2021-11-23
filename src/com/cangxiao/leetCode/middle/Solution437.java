package com.cangxiao.leetCode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/11/14
 * @Desc 437. 路径总和 III
 */
public class Solution437 {

//========================================前缀和=============================

    /**
     * 我们利用先序遍历二叉树，记录下根节点 root 到当前节点 p 的路径上除当前节点以外所有节点的前缀和，
     * 在已保存的路径前缀和中查找是否存在前缀和刚好等于当前节点到根节点的前缀和 curr 减去 targetSum。
     *
     * @param root
     * @param targetSum
     * @return
     */
    private int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        //存储前缀和
        Map<Long, Integer> preSum = new HashMap<>();
        //初始化根节点前缀和为0;
        preSum.put(0L, 1);
        return dfs(root, targetSum, 0, preSum);
    }

    private int dfs(TreeNode root, int targetSum, long currSum, Map<Long, Integer> preSun) {
        if (root == null) return 0;
        int result = 0;
        currSum += root.val;
        /*
            如当前节点的前缀和为 10 + 5 + 3;目标和targetSum = 8；如果前缀和preSum中存在（curr-targetSum）的值，啧路径条数加1;
            否则不存在加0;
         */
        result += preSun.getOrDefault(currSum - targetSum, 0);
        //存储当前前缀和
        preSun.put(currSum, preSun.getOrDefault(currSum, 0) + 1);
        result += dfs(root.left, targetSum, currSum, preSun);
        result += dfs(root.right, targetSum, currSum, preSun);
        //删除当前节点的前缀和 状态恢复代码的作用就是： 在遍历完一个节点的所有子节点后，将其从map中除去。
        //遍历完当前节点的左右子节点，在map中将当前节点的前缀和减1，因为当前节点的前缀和只对子节点有效
        preSun.put(currSum, preSun.getOrDefault(currSum - targetSum, 0) - 1);
        return result;
    }

    //=============================================递归=======================================
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int result = rootSum2(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    private int rootSum2(TreeNode root, int targetSum) {
        int result = 0;
        if (root == null) return result;

        if (root.val == targetSum) {
            result += 1;
        }
        /*
            若当前节点和目标值相同， 则向下搜索找到和为0的路径；
            若当前节点和目标值不相同， 则向下搜索找到和为目标值与当前节点值差值的路径；
         */
        result += rootSum2(root.left, targetSum - root.val);
        result += rootSum2(root.right, targetSum - root.val);
        return result;
    }
}
