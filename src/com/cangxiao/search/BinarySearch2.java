package com.cangxiao.search;

import com.cangxiao.stack.Valid;

import java.math.BigDecimal;

/**
 * @Author cangxiao
 * @Date 2021/7/24
 * @Desc 二分查找
 */
public class BinarySearch2 {

    /**
     * 递归模式
     *
     * @return
     */
    int index = Integer.MAX_VALUE;

    public int search(int[] array, int low, int high, int value) {

        if (low <= high) {
            //如果 low 和 high 比较大的话,两者之和就有可能会溢出,
            int mid = low + ((high - low) >> 1);
            if (value > array[mid]) {
                mid = search(array, mid + 1, high, value);
            } else if (value < array[mid]) {
                mid = search(array, low, mid - 1, value);
            } else {
                if (mid == 0 || array[mid - 1] == value) return mid;
                else high = mid - 1;
            }
        }

        return index;

    }

    public int minSearch(int[] array, int value) {
        int index = search(array, 0, array.length - 1, 55);
        while (array[index] == value) {
            index--;
            if(index<0){
                return -1;
            }
        }
        return index + 1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @return
     */
    public int search1(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            /*
             * value!=arrar[mid] ,所以此处 low 可以等于mid+1; high = mid-1;
             */
            if (value > array[mid]) {
                low = mid + 1;
            } else if (value < array[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || value != array[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @return
     */
    public int search2(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            /*
             * value!=arrar[mid] ,所以此处 low 可以等于mid+1; high = mid-1;
             */
            if (value > array[mid]) {
                low = mid + 1;
            } else if (value < array[mid]) {
                high = mid - 1;
            } else {
                if (mid == array.length - 1 || value != array[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;

    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @return
     */
    public int search3(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid]>=value){
                if(mid==0 || array[mid-1]<value) return mid;
                else high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;

    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @return
     */
    public int search4(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid]<=value){
                if(mid==array.length-1 || array[mid+1]>value) return mid;
                else low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] array = {8,11,19,23,27,33,45,55,67,98};
        int[] array = {33, 45, 55, 55, 55, 67, 98};
        BinarySearch2 binarySearch = new BinarySearch2();
        int index = binarySearch.search2(array, 11);
        System.out.println("index = " + index);
        index = binarySearch.search1(array, 55);
        System.out.println("index = " + index);
        index = binarySearch.search2(array, 55);
        System.out.println("index = " + index);
//        array = new int[]{3,4,6,7,10};
        index = binarySearch.search3(array, 99);
        System.out.println("index = " + index);
        index = binarySearch.search4(array, 55);
        System.out.println("index = " + index);

    }


}
