package com.cangxiao.leetCode.easy;

import javax.print.attribute.standard.NumberOfInterveningJobs;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @Author cangxiao
 * @Date 2021/9/22
 * @Desc 35. 搜索插入位置
 */
public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }

                right = mid - 1;
            } else {
                if (mid == right || nums[mid + 1] > target) {
                    return mid + 1;
                }

                left = mid + 1;
            }
        }
        return mid + 1;
    }

    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        System.out.println(solution.searchInsert(new int[]{1, 3}, 4));
    }
}
