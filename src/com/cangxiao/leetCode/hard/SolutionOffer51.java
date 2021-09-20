package com.cangxiao.leetCode.hard;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * @Author cangxiao
 * @Date 2021/9/15
 * @Desc 剑指 Offer 51. 数组中的逆序对
 */
public class SolutionOffer51 {

    /**
     * 逆序对的个数= 逆序度。
     * 归并排序值有在merge操作的时候才会降低逆序度，所以所以merge操作降低了多少逆序度即存在多少个逆序对
     * 如merge两个数组A = {3，5，8} B={2,4,6} merge操作的时候A数组和B数组已经有序，只有A与B之间存在逆序度
     * 每当将B数组中的数字放到新数组的时候，逆序度即为A数组中剩余的数字个数
     *
     * @param nums
     * @return
     */
    int reversePairs = 0;
    public int reversePairs(int[] nums) {
        sort(nums,0,nums.length-1);
        return reversePairs;
    }

    public void sort(int[] nums, int p, int r) {
        if (p >= r) return;
        int q = p + (r - p) / 2;
        sort(nums, p, q);
        sort(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    public void merge(int[] nums, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int[] temp = new int[r - p + 1];
        for (int k = 0; k < temp.length; k++) {
            if (i > q) {
                temp[k] = nums[j++];
                continue;
            }
            if (j > r){
                temp[k] = nums[i++];
                continue;
            }
            if (nums[i]> nums[j]){
                reversePairs += (q+1-i);
                temp[k] = nums[j++];
            }else {
                temp[k] = nums[i++];
            }
        }
        for (int k = 0; k < temp.length; k++) {
            nums[p+k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2};
        SolutionOffer51 solution = new SolutionOffer51();
        solution.reversePairs(array);
        System.out.println(Arrays.toString(array));
        System.out.println(solution.reversePairs);
    }
}
