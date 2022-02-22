package com.cangxiao.offer;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/2/21
 * @Desc 剑指 Offer 03. 数组中重复的数字
 * 1. 排序
 * 2. 找出相邻相同的元素
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
//        quickSort(nums,0,nums.length-1);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    private void quickSort(int[] arr, int left, int right){
        if (left>right) return;
        int q = partition(arr, left, right);
        quickSort(arr,left, q-1);
        quickSort(arr, q+1, right);
    }

    private int partition(int[] arr, int left, int right) {
        //选择第一个数为基准值
        int temp = arr[left];
        while (left<right){
            //若基准值小于右边的值则右指针向左移
            while (left<right && temp <= arr[right]){
                right--;
            }
            if (left!=right){
                swap(arr,left,right);
            }
            //若基准值大于左边的值则左指针向右移
            while (left<right && temp > arr[left]){
                left++;
            }
            if (left!=right){
                swap(arr,left,right);
            }
        }
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        Offer03 offer03 = new Offer03();
        int repeatNumber = offer03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println("repeatNumber = " + repeatNumber);
    }

}
