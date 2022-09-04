package com.cangxiao.array;

import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;

/**
 * @Author cangxiao
 * @Date 2022/7/29
 * @Desc 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
//        int[] nums = {1,3};
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, 0));
    }
}
