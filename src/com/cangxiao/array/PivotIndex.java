package com.cangxiao.array;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/7/29
 * @Desc https://leetcode-cn.com/problems/find-the-middle-index-in-array/
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, -1, 0, 0, -2, 2};
        int[] nums = {2, -2, 0, 0, -1, 1};
//        int[] nums = {2, 1, -1};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println("solution.pivotIndex(nums) = " + pivotIndex.pivotIndex(nums));
    }
}
