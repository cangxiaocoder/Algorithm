package com.cangxiao.search;

/**
 * @Author cangxiao
 * @Date 2021/4/14
 * @Desc
 */
public class Test {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(52);
        TreeNode node2 = new TreeNode(89);
        TreeNode node3 = new TreeNode(49,null,node1);
        TreeNode node4 = new TreeNode(69,node3,node2);
        TreeNode node5 = new TreeNode(90,node4,null);
        Solution solution = new Solution();
        int min = solution.minDiffInBST(node5);
        System.out.println("min = " + min);

        Solution2 solution2 = new Solution2();
        min = solution2.minDiffInBST(node5);
        System.out.println("min = " + min);
    }
}
