package com.cangxiao.leetCode.code88;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/8/7
 * @Desc 合并两个有序数组
 */
public class Solution {
    /**
     * 双指针东头遍历，使用临时数组存储变量
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length<1) return;
        int i = 0, j = 0, k=0;
        int[] temp = new int[nums1.length];
        while (k<nums1.length){
            if(i >= m){
                temp[k++] = nums2[j++];
                continue;
            }
            if(j >= n){
                temp[k++] = nums1[i++];
                continue;
            }
            if(nums1[i]<=nums2[j]){
                temp[k++] = nums1[i++];
            }else {
                temp[k++] = nums2[j++];
            }
        }
        System.arraycopy(temp, 0, nums1, 0, nums1.length);
    }

    /**
     * 双指针从后遍历， 数组本有序，谁大先放在后面，不需要临时数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length<1) return;
        int i = m-1, j = n-1, k=nums1.length-1;

        while (k>=0){
            if(i<0){
                nums1[k--] = nums2[j--];
                continue;
            }
            if(j<0){
                nums1[k--] = nums1[i--];
                continue;
            }
            if(nums1[i]>=nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        Solution solution = new Solution();
//        solution.merge1(nums1,m,nums2,n);
        solution.merge2(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
