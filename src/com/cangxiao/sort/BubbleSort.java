package com.cangxiao.sort;

import java.util.Arrays;

/**
 * 每次只比较相邻的两个元素， 如果前一个元素大于后一个元素，交换位置
 * @Author cangxiao
 * @Date 2021/6/20
 * @Desc 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] array){
        if(array.length==0)return;
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            //每一轮都将最大的元素排到了最后，最后i个元素不需要再比较了
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            //如果flag的值为false，说明这次冒泡没有进行过交换，即数据已完全有序
            if(!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {24,15,13,28,10,11,1,5,3};
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
