package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/9/25
 * @Desc 852. 山脉数组的峰顶索引
 */
public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (left == right) {
                return left;
            }
            int mid = left + (right - left) / 2;
            if (mid==0 && arr[mid]>arr[mid+1]){
                return mid;
            }
            if (mid==right && arr[mid]>arr[mid-1]){
                return mid;
            }
            if (mid!=0 && mid!=right && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if (arr[mid]<arr[mid+1]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        //当left和right相等时处在最高点
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid]<arr[mid+1]){
                left = mid + 1;
            }else {
                //mid可能正好处在定点， 如果right = mid - 1 则会跳过定点
                right = mid;
            }
        }
        return left;
    }
}
