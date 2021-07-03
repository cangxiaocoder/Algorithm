package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/1
 * @Desc 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] array = {13,15,24,99,14,11,1,2,3};
//        int[] array = {6,11,3,9,8,6};
        int[] array = {1,2,3,4,5,6};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int p, int r){
        if(p>=r) return;
        int q = partition(array,p,r);
        sort(array,p,q-1);
        sort(array,q+1,r);
    }

    /**
     * i 指向大于分区点的值，j 用于扫描整个数组，
     * 如果 i 指向的值小于分区值，则 i+1；
     * 如果 i 指向的值大于分区值，i 不变，j 继续扫描数组，
     * 直到 j指向的值小于分区值，交换这 i 和 j 索引值的位置，然后 i+1(经过交换后，i 索引的值小于分区值吗，所以 i 需要加1)
     * 如果 i 和 j 相等说明指向同一个值，则不需要交换，
     * @return
     */
    public int partition(int[] array, int p, int q){
        int i = p;
        int pivot = array[q];
        for (int j = i; j < q; j++) {
            //i 指向大于pivot的值，如果当前值小于pivot ,则交换位置
            if(array[j]<pivot) {
                if(i!=j){
                    swap(array,i , j);
                }
                i++;
            }
            System.out.println(Arrays.toString(array));
        }
        //最后交换i和pivot的位置；将pivot的值放到数组中间
        swap(array,i,q);
        System.out.println(" i = " + i);
        return i;
    }
    public void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
