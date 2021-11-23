package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/17
 * @Desc 堆排序 - 小顶堆
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int[] array = {6,24,13,28,10,11,1,5,3};
//        int[] array = {0,2};
        HeapSort2 heapSort = new HeapSort2();
        heapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 1. 构建大顶堆
     * 2. 堆化后堆顶元素为最大值，将最大值与最后一个值交换，除这个最大的元素外，将剩下的元素重新堆化
     * 3. 每次堆化都可以得到堆顶的最大值，当构建的堆只有一个元素时则排序完成
     * @param array
     */
    public void sort(int[] array){
        if(array.length<2)return;
         //建堆
         buildHeap(array,array.length-1);
         //排序
         int k = array.length - 1;
         while (k > 0) {
             // 将堆顶元素与最后一个元素交换位置,
             swap(array, 0, k);
             // 将剩下元素重新堆化，堆顶元素变成最值
             heapify(array, --k, 0);
         }
     }

    /**
     * 从后往前处理数组，当父节点小于子节点，啧交换两个节点的值，执行自上而下的堆化，由于叶子节点没有子节点，所以不用处理
     * 由于第一个节点不存储元素，所以(array.length-1)/2 为最后一个叶子节点的父节点,
     * @param array
     */
    private void buildHeap(int[] array, int n) {

        for (int i = n/2; i >= 0; i--) {
            heapify(array,n,i);
        }
    }

    private void heapify(int[] array, int n, int i) {
        while (true){
            //最小值的索引位置,如果当前节点既，既小于左子节点也小于右子节点，
            // 需要将最小值放到最后所以需要与右子节点交换位置
            int minIndex = i;
            if(2*i+1<=n && array[i]>array[2*i+1]){
                minIndex = 2*i+1;
            }
            if(2*i+2<=n && array[minIndex]>array[2*i+2]){
                minIndex = 2*i+2;
            }
            if(i==minIndex)break;
            swap(array,minIndex,i);
            //记录交换后的索引
            i = minIndex;
        }
    }
    private void swap(int[] heap, int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
