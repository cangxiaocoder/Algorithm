package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/11/7
 * @Desc 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 后序遍历：左子树 ==》 右子树 ==》 根
     * postorder[j] 即为根节点
     * @param array
     * @param left
     * @param right
     * @return
     */
    private boolean verifyPostorder(int[] array, int left, int right){
        //当没有节点或只有一个节点是，递归结束
        if(left>=right){
            return true;
        }
        //后序遍历最后一个节点一定为根节点
        int root = array[right];
        //在数组中找到第一个比根节点大的值， 则这个值之后的节点(除了根节点)都是它的右子树，之前的节点都为它的左子树
        int mid = left;
        while (array[mid]<root){
            mid++;
        }
        int temp = mid;
        while (temp<right){
            //右子树都应该比根节点大，如果出现小于根节点的择不是后序遍历
            if(array[temp++]<root){
                return false;
            }
        }
        /*
            递归所有的子树
         */
        return verifyPostorder(array,left, mid-1) && verifyPostorder(array, mid, right-1);
    }

}
