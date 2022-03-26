package com.cangxiao.offer;

import com.cangxiao.offer.common.TreeNode;

/**
 * @Author cangxiao
 * @Date 2022/3/24
 * @Desc 剑指 Offer 26. 树的子结构
 */
public class Offer26 {
    /**
     * 若B是A的子树，则B的根节点一定是A的某一个节点
     * 先判断B的根节点是否是A的根节点
     * 若不是，然后判断A的左右节点那个是B的根节点
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return (printA(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));

    }

    private boolean printA(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A==null || A.val != B.val) return false;
        return printA(A.left,B.left) && printA(A.right,B.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
//        B.right = new TreeNode(3);
        Offer26 offer26 = new Offer26();
        System.out.println("isSubStructure = " + offer26.isSubStructure(A, B));
    }
}
