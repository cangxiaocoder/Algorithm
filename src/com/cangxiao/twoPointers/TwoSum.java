package com.cangxiao.twoPointers;

import java.util.Arrays;

/**
 * @Author: cangxiao
 * @Since: 1/11/2026
 * @description: 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return null;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] nums = {2,7,11,15};
//        int[] nums = {2, 3, 4};
        int[] nums = {-1,0};
        int[] result = twoSum.twoSum(nums, -1);
        System.out.println(Arrays.toString(result));
    }
}
