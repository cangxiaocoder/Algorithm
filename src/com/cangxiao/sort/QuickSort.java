package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/3/31
 * @Desc 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {13,15,24,99,14,11,1,2,3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array,int left,int right){
        if(left<right){
            int middle = sort(array, left, right);
            //每次只需quickSort将原数组一份为2；
            quickSort(array, left, middle-1);
            quickSort(array, middle+1, right);
        }
    }

    public int sort(int[] array,int left,int right){

//        int middle = (left+right)/2;
        //选择一个基准值，大于基准值的放右边，小于基准值的放左边
        int temp = array[left];
        while (left<right){
            //从右往左，右边的值大于基准值，不需要交换位置，比较下一个值
            while (temp<array[right]){
                right--;
            }
            //当右边的值小于基准值时，交换位置，将右边小的值放到左边
            swap(array,left,right);
            //从左往右，基准值大于左边的值，不需要交换位置，比较下一个值
            while (temp>array[left]){
                left++;
            }
            //当左边的值大于基准值时，交换位置，将左边大的值放到右边
            swap(array,left,right);
        }
        //排序完，基准值都会排到数组的中间位置；即 left==right时
        int middle = left;
        return middle;
    }

    private void swap(int[] array,int left, int right) {
        int t = array[left];
        array[left] = array[right];
        array[right] = t;
    }
}
