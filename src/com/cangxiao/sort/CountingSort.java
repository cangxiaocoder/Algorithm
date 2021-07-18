package com.cangxiao.sort;

import java.util.Arrays;

/**
 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 * 而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数
 * @Author cangxiao
 * @Date 2021/7/15
 * @Desc 计数排序
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] array = {2,5,3,0,2,3,0,8};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
    //2，5，3，0，2，3，0，3
    public void sort(int[] array){
        if(array.length<2)return;
        //查询最大的元素
        int max = array[0];
        for (int j : array) {
            if (max < j) {
                max = j;
            }
        }
        //桶c用于存储数组中每个值的数量，索引为 0 - max;
        int[] c = new int[max+1];
        for (int j : array) {
            c[j]++;
        }
        //累加数组c
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i]+c[i-1];
        }
        int[] temp = new int[array.length];
        for (int j : array) {
            temp[--c[j]] = j;
        }
        //重新将结果拷贝到原数组
        System.arraycopy(temp, 0, array, 0, temp.length);
    }
}
