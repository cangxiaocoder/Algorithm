package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/12
 * @Desc 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
//        int[] array = {1,24,13,28,10,11,1,5,3};
        int[] array = {2, 4, 5, 2, 2};
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(array, 2);
        System.out.println(Arrays.toString(array));
    }


    public void sort(int[] array, int bucketSize) {
        if (array.length < 2) return;
        int min = array[0];
        int max = array[1];
        for (int value : array) {
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        //桶数量
        int bucketCount = (max - min) / bucketSize + 1;
        //包含多个桶， 每个桶中包含多个元素
        int[][] buckets = new int[bucketCount][bucketSize];
        //每个桶中存放数据的索引；初始值都为0；
        int[] indexArr = new int[bucketCount];
        for (int value : array) {
            //每个值应放的桶的索引
            int bucketIndex = (value - min) / bucketSize;
            //因为indexArr[bucketIndex] 自增会多加 1，所以此处不需要减1
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                //桶已经装满，需要扩容
                ensureCapacity(buckets, bucketIndex);
            }
            /*  buckets[bucketIndex] 第bucketIndex个桶
                indexArr[bucketIndex]  第bucketIndex个桶中的索引,从0开始 ；
             */
            buckets[bucketIndex][indexArr[bucketIndex]] = value;
            //当桶中放入元素后， 索引自增
            indexArr[bucketIndex]++;
        }
        //使用快速排序对桶进行排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] < 2) continue;
            QuickSort2 quickSort2 = new QuickSort2();
            //此处j 不能是小于桶的大小， 有些桶可能没有装满数据，
            quickSort2.sort(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                array[k++] = buckets[i][j];
            }
        }
    }

    /**
     * 扩容数组
     *
     * @param buckets     所有桶
     * @param bucketIndex 需要扩容桶的索引
     */
    private void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] temArr = buckets[bucketIndex];
        int[] newArr = new int[temArr.length * 2];
        for (int i = 0; i < temArr.length; i++) {
            newArr[i] = temArr[i];
        }
        buckets[bucketIndex] = newArr;
    }
}
