package com.cangxiao.leetCode.middle;

import com.cangxiao.heap.Heap;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * @Author cangxiao
 * @Date 2021/9/22
 * @Desc 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] array = new int[]{-1,-1};
        while (left <= right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                if (mid==0 || nums[mid-1]!=target){
                    array[0] = mid;
                    break;
                }else {
                    right = mid-1;
                }

            }else if (nums[mid]<target){
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        left = 0; right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                if (mid==right || nums[mid+1]>target){
                    array[1] = mid;
                    break;
                }else {
                    left = mid+1;
                }

            }else if (nums[mid]<target){
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11)));
    }
}
