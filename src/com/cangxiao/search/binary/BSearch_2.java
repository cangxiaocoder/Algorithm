package com.cangxiao.search.binary;

/**
 *
 * @Author cangxiao
 * @Date 2021/9/20
 * @Desc 有重复数据的循环有序数组中查找最后一个比给定值小的数
 * 7,9,10,11,15，1,2,3,4,5,5
 */
public class BSearch_2 {
    
    public int search(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (array[mid] <= target){
                if (mid==array.length-1 || array[mid+1]>target){
                    return mid;
                }
                if (array[low]< target){
                    //如果正好在有序的区间内
                    high = mid - 1;
                }else {
                    low = mid +1;
                }
            }else if (array[low] <= array[mid]) { //说明在[low,mid]区间有序
                if (array[low]< target && target < array[mid]){
                    //如果正好在有序的区间内
                    high = mid - 1;
                }else {
                    low = mid +1;
                }
            }else { //说明在[mid,high]区间有序
                if (array[mid]< target && target < array[high]){
                    //如果正好在有序的区间内
                    low = mid +1;

                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BSearch_2 bSearch_2 = new BSearch_2();
        System.out.println("有重复数据的循环有序数组中查找最后一个比给定值小的数 11 = " + bSearch_2.search(new int[]{7, 9, 10, 10, 15, 1, 2, 3, 4, 5, 5}, 11));
        System.out.println("有重复数据的循环有序数组中查找最后一个比给定值小的数 10 = " + bSearch_2.search(new int[]{7, 9, 10, 10, 15, 1, 2, 3, 4, 5, 5}, 10));
    }
}
