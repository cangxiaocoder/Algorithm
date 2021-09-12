package com.cangxiao.leetCode.interview;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 面试题 10.01. 合并排序的数组
 */
public class Solution10_01 {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int tail = m + n - 1;
        while (i>=0 && j>=0){
            if (A[i]<B[j]){
                A[tail--] = B[j--];
            }else {
                A[tail--] = A[i--];
            }
        }
        while (i>=0){
            A[tail--] = A[i--];
        }
        while (j>=0){
            A[tail--] = B[j--];
        }
    }


}
