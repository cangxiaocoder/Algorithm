package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/6/20
 * @Desc 插入排序
 */
public class SelectionSort {

    public static void sort(int[] array){
        if(array.length<2)return;
        for (int i = 0; i < array.length; i++) {
            int min = i;
            //每次讲最小值移动到最前面，所有只需要比较后面未排序的
            for (int j = i; j < array.length; j++) {
                //找出未排序中的最小值
                if(array[j]<array[min]){
                    min = j;
                }
            }
            //将最小值与未排序的第一个值进行交换
            swap(array, i, min);
        }
    }

    private static void swap(int[] array, int i, int min) {
        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }


    public static void main(String[] args) {
        int[] array = {1,24,13,28,15,11,1,5,3};
//        int[] array = {4,6,7,5};
        SelectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
