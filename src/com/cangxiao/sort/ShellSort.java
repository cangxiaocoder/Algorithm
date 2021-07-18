package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/17
 * @Desc 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] array = {2,5,3,0,2,3,0,8};
        int[] array = {3,2,6,4,5,1};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public void sort(int[] array){
        if(array.length<2)return;
        int step = array.length/2;
        while (step>=1){
            for (int i = step; i < array.length; i++) {
                int value = array[i];
                int j = i-step;
                for (; j >=0; j=j-step) {
                    //
                    if(value<array[j]){
                        //如果已排序的元素大于value，将这个元素向后移动step步
                        array[j+step] = array[j];
                    }else {
                        break;
                    }
                }
                array[j+step] = value;
                System.out.println(Arrays.toString(array));
            }
            step=step/2;
        }
    }

}
