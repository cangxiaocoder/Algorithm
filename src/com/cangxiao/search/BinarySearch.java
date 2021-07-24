package com.cangxiao.search;

import com.cangxiao.stack.MinStack;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author cangxiao
 * @Date 2021/7/24
 * @Desc 简单的二分查找
 */
public class BinarySearch {

    /**
     * 递归模式
     * @return
     */
    public int search1(int[] array, int low, int high, int value) {
        if (low <= high) {
            //如果 low 和 high 比较大的话，两者之和就有可能会溢出,
           int mid = low + ((high - low)>>1);
            if (array[mid] == value) {
                return mid;
            }
            if (value > array[mid]) {
               return search1(array, mid, high, value);
            }else {
               return search1(array, low, mid, value);
            }
        }
        return -1;

    }

    /**
     * 非递归模式
     * @return
     */
    public int search2(int[] array, int value) {
        int low = 0;
        int high = array.length-1;
        while (low<=high){
            int mid = low + ((high - low)>>1);
            if(array[mid] == value){
                return mid;
            }
            /*
             * value!=arrar[mid] ，所以此处 low 可以等于mid+1; high = mid-1;
             */
            if (value > array[mid]) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
//        int[] array = {8,11,19,23,27,33,45,55,67,98};
        int[] array = {8,11,19,23,27,33,45,55,67,98};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search1(array,0, array.length-1, 55);
//        int index = binarySearch.search2(array, 19);
        System.out.println("index = " + index);
        System.out.println(binarySearch.squareRoot(6));

    }

    public double squareRoot(int a){
        double low = 0;
        double high = a;
        double mid = 0;
        while (low<=high){
            mid = low + ((high - low)/2);
            if(mid*mid == a){
                return mid;
            }
            /*
             * value!=arrar[mid] ，所以此处 low 可以等于mid+1; high = mid-1;
             */
            if (mid*mid < a) {
                low = mid+0.000001;
            }else {
                high = mid-0.000001;
            }
        }
        return BigDecimal.valueOf(mid).setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
