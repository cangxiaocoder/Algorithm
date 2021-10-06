package com.cangxiao.leetCode.easy;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 1122. 数组的相对排序
 */
public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i = 0;
        int[] hash = new int[1001];
        for (int arr : arr1) {
            hash[arr]++;
        }
        for (int arr : arr2) {
            //hash[arr]>0说明arr1中存在arr2中的元素
            while (hash[arr]>0){
                arr1[i++] = arr;
                hash[arr]--;
            }
        }
        for (int j = 0; j < hash.length; j++) {
            while (hash[j]>0){
                arr1[i++] = j;
                hash[j]--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        Solution1122 solution = new Solution1122();
        int[] ints = solution.relativeSortArray(new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31}, new int[]{2, 42, 38, 0, 43, 21});
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
