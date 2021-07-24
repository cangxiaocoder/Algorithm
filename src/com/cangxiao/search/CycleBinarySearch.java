package com.cangxiao.search;

/**
 * @Author cangxiao
 * @Date 2021/7/24
 * @Desc 循环有序数组
 */
public class CycleBinarySearch {

    public int search(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[minIndex] >= array[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int search(int[] array, int value) {
        if (array.length < 1) return -1;
        if (array.length == 1) return array[0] == value ? 0 : -1;
        int minIndex = search(array);
        int low = 0;
        int high = array.length - 1;
        //minIndex==0 说明有序数组为旋转
        if (minIndex != 0) {
            if (array[0] > value) {
                low = minIndex;
            } else {
                high = minIndex;
            }
        }

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            }
            if (value > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] array, int value) {
        if (array.length < 1) return -1;
        if (array.length == 1) return array[0] == value ? 0 : -1;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) return mid;
            /*
                如果array[0] <= array[mid] ，说明在0-mid这个区间是按顺序排列的；
                否则在 mid-array.length-1这个区间是按顺序排列的
                通过提高low的值，或减小high的值， 使数组在low-high区间有序；

             */
            if (array[0] <= array[mid]) {
                if (array[0] <= value && value < array[mid]) {
                    //value 在0-mid这个有序区间，
                    high = mid - 1;
                } else {
                    //value 不在0-mid这个区间，
                    low = mid + 1;
                }
            } else {
                if (array[mid] < value && value <= array[array.length - 1]) {
                    //value 在mid-array.length-1这个有序区间，
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = {4,5,6,1,2,3};
        int[] array = {3, 1};
        CycleBinarySearch cycleBinarySearch = new CycleBinarySearch();
//        int index = cycleBinarySearch.search(array, 3);
        int index = cycleBinarySearch.search2(array, 1);
        System.out.println("index = " + index);
    }
}


