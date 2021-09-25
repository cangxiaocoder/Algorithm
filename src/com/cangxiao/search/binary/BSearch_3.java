package com.cangxiao.search.binary;

/**
 * @Author cangxiao
 * @Date 2021/9/20
 * @Desc 无重复数据的循环有序数组中查找最小值
 * 7,9,10,11,15，1,2,3,4,5,5
 */
public class BSearch_3 {
    
    public int search(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = low+(high - low)/2;
            if (low==high) return mid;
            if (mid!=0 && array[mid-1]>array[mid]|| //mid左边的值大于右边的值 mid是最小值
            mid==0 && array[mid]<array[high]){ // mid等于0而且小于最右边的值，数组完全有序
                return mid;
            }
            if (array[mid]>array[high]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BSearch_3 bSearch_3 = new BSearch_3();
        System.out.println("无重复数据的循环有序数组中查找最小值  = " + bSearch_3.search(new int[]{7, 9, 10, 10, 15, 1, 2, 3, 4, 5, 5}, 11));
        System.out.println("无重复数据的循环有序数组中查找最小值  = " + bSearch_3.search(new int[]{ 1, 2, 3, 4, 5, 5}, 10));
    }
}
