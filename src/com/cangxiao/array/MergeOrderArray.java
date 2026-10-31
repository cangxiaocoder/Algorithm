package com.cangxiao.array;

/**
 * @Author: cangxiao
 * @Since: 31/10/2026
 * @description: 合并两个有序数组
 */
public class MergeOrderArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            }else {
                nums1[k--] = nums1[i--];
            }
        }
//        num1前面本就有序，无需重新赋值
//        while (i >= 0){
//            nums1[k--] = nums1[i--];
//        }
        while (j >=0){
            nums1[k--] = nums2[j--];
        }
    }

    public int[] merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i =0, j = 0, k = 0;
        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m){
            nums[k++] = nums1[i++];
        }
        while (j < n){
            nums[k++] = nums2[j++];
        }
        return nums;
    }

    public static void main(String[] args) {
        MergeOrderArray mergeOrderArray = new MergeOrderArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int[] nums2 = {0, 2, 5, 6};
       mergeOrderArray.merge(nums1, 3, nums2, 4);
        for (int i : nums1)
            System.out.print(i + " ");
    }
}
