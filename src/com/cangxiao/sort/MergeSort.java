package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/4
 * @Desc 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] array = {1,24,13,28,10,11,1,5,3};
        int[] array = {3, 4, 1, 2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int p, int r) {
        //当只有一个元素是结束递归
        if (p >= r) return;

        int q = p + (r - p) / 2;
        sort(array, p, q);
        sort(array, q + 1, r);

        merge2(array, p, q, r);
    }


    public void merge(int[] array, int p, int q, int r) {

        int i = p, j = q + 1;
        int[] tem = new int[r - p + 1];
        for (int k = 0; k < tem.length; k++) {
            //当i>q,说明p到q区间已经遍历完了，直接将q到r区间的值付给tem数组
            if (i > q) {
                tem[k] = array[j++];
                continue;
            }
            //当i>q,说明q到r区间已经遍历完了，直接将p到q区间的值付给tem数组
            if (j > r) {
                tem[k] = array[i++];
                continue;
            }
            //比较两个区间，先将小的值放到临时数组
            if (array[i] < array[j]) {
                tem[k] = array[i++];
            } else {
                tem[k] = array[j++];
            }
        }
        //将临时数组重新拷如到原array数组
        for (int k = 0; k < tem.length; k++) {
            //注：array数组需要加上p,每次拷入的都是p到r区间
            array[p + k] = tem[k];
        }
    }

    /**
     * 哨兵模式
     *
     * @param array
     * @param p
     * @param q
     * @param r
     */
    public void merge2(int[] array, int p, int q, int r) {
        //多加一个空间，用于放哨兵
        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            left[i] = array[p + i];
        }
        //最后一位放哨兵
        left[q - p + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < r - q; i++) {
            //left数组中已经存在了array[q]此处需要在加 1；
            right[i] = array[q + i + 1];
        }
        //最后一位放哨兵
        right[r - q] = Integer.MAX_VALUE;
        int i = 0, j = 0, k = p;
        while (k <= r) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
    }
}
