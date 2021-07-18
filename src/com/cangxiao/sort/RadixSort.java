package com.cangxiao.sort;

import java.util.Arrays;

/**
 *
 * @Author cangxiao
 * @Date 2021/7/17
 * @Desc 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        String[] phoneNum = {"13910537066", "15801657222", "13910448588", "13911716899", "13810111162", "13811735000", "15201000057", "13501350203", "13691110987",
                "13701111379", "18500000690", "18500000586", "18500000151", "18500000631", "17600087654", "18600000236", "18511111655",
                "18500000782", "18501046789", "18613486789", "13311091188", "19919851986", "19919941491", "18911922223", "19919850912",
                "18911766662", "19919959599", "19919991171", "19919990992", "13366261919"};
//        int[] array = {37066,57222,48588,16899,10111162,919};
//        int[] array = {37,57,48,16,101,91};
        int[] array = {3,5,4,1,10,9};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        int max = array[0];
        for (int v : array) {
            if (v > max) max = v;
        }
        //从个位开始，对每一位进行计数排序；个位、十位、百位......;
        for (int k = 1; max / k > 0; k *= 10)
            countingSort(array, k);
    }

    /**
     * 对某个位数进行计数排序
     *
     * @param array
     * @param k
     */
    public void countingSort(int[] array, int k) {
        if(array.length<2) return;
        //计算当前位元素的个数
        int[] c = new int[10];
        for (int value : array) {
            c[(value / k) % 10]++;
        }
        //按顺序累加数组c
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i]+c[i-1];
        }

        int[] temp = new int[array.length];
        /*
            此处需要倒序遍历， 当数据位数不同时，低位已经排好序了，而k超过低位，k所在的位置均为0
            如 3,5,4,1,10,9 个位排序后：10,1,3,4,5,9
             排序十位时，则c[0] = 5;c[1到9] = 6；如果按顺序遍历，1会排到索引c[0]-1的位置
         */
        for (int i = array.length - 1; i >= 0; i--) {
            //数组c中存储是当前元素的个数，做索引时需要减 1；
            temp[--c[(array[i] / k) % 10]] = array[i];
        }
        //重新将结果拷贝到原数组
        System.arraycopy(temp, 0, array, 0, temp.length);
    }
}
