package com.cangxiao.offer;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/6/15
 * @Desc 剑指 Offer 40. 最小的k个数
 */
public class Offer40 {

    public static void main(String[] args) {
       int[] arr = new int[]{4,5,1,6,2,7,3,8};
        // int[] arr = new int[]{3,2,1};
        Offer40 offer40 = new Offer40();
        int[] numbers = offer40.getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(numbers));
    }
    int[] result;
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k > arr.length){
            return arr;
        }
        result  = new int[k];
        sort(arr, 0, arr.length - 1,k);
        System.arraycopy(arr, 0, result, 0, k);
        System.out.println(Arrays.toString(arr));
        return result;
    }

    public void sort(int[] arr, int left, int right, int k) {
        if (left < right){
            int index = partition(arr, left, right);
            if (k < index){
                sort(arr, left, index - 1, k);
            }else if (k > index){
                sort(arr, index + 1, right, k);
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        int temp = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= temp) {
                left++;
            }
            if (left != right) {
                swap(arr, left, right);
            }
            while (left < right && arr[right] > temp) {
                right--;
            }
            if (left != right) {
                swap(arr, left, right);
            }
        }
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
