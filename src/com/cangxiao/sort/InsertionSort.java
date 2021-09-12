package com.cangxiao.sort;

import java.util.Arrays;

/**
 * 将未排序区间的元素B和已排序的元素[A,C]做比较，如果未排序的元素B小于做比较的元素C，将其插入到这个元素C之前
 * 每次只需要比较已经排序的元素区间， 初始排序区间里只有一个元素，即第一个元素
 * eg：前面345已排序，132未排序，选择未排序区间第一个元素，value=1 与已排序区间比较
 *          346132
 * 移动     346632        value = 1;
 * 移动     344632        value = 1;
 * 移动     334632        value = 1;
 * 插入     134632        value = 1;
 * @Author cangxiao
 * @Date 2021/6/20
 * @Desc 插入排序
 * 1.时间复杂度：
 * 最好情况：数据已有序， 时间复杂度是O(n)
 * 最坏情况：数据是倒序，时间复杂度是O(n^2)
 * 平均情况：时间复杂度是O(n^2)
 * 2.空间复杂度：
 * O(1)
 * 3.原地排序算法
 * 4.稳定的排序算法
 */
public class InsertionSort {

    public static void sort(int[] array){
        if(array.length<2)return;
        for (int i = 1; i < array.length; i++) {
            //取未排序区间的值
            int value = array[i];
            int j = i-1;
            for (;j>=0;j-- ) {
                //将value与已排序的所有元素做比较
                if(array[j]>value){
                    //如果已排序的元素大于value，将这个元素向后移动
                    array[j+1] = array[j];
                }else {
                    //如果不大于， 说明找到了插入的位置
                    break;
                }
            }
            //最后一次比较j多自减了一次，此处需要加 1
            array[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,24,13,28,10,11,1,5,3};
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
