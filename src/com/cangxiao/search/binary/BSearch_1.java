package com.cangxiao.search.binary;

/**
 *
 * @Author cangxiao
 * @Date 2021/9/20
 * @Desc 无重复数据的循环有序数组中查找给定值
 * 7,9,10,11,15，1,2,3,4,5,6
 */
public class BSearch_1 {
    
    public int search(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (array[mid] == target){
                return mid;
            }
            if (array[low] <= array[mid]) { //说明在[low,mid]区间有序
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
        BSearch_1 bSearch_1 = new BSearch_1();
        System.out.println("无重复数据的循环有序数组中查找给定值 10 = " + bSearch_1.search(new int[]{7, 9, 10, 11, 15, 1, 2, 3, 4, 5, 5}, 6));
    }
}
