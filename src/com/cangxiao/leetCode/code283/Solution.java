package com.cangxiao.leetCode.code283;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2023/11/26
 * @Desc 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
             // 找到第一个为0 的索引i
            if (nums[i] != 0) {
                i++;
                j++;
                continue;
            }
            // 找到0后第一个不为0的索引
            while (j < nums.length) {
                if (nums[j] != 0) {
                    break;
                }
                j++;
            }
            // 将0向后移动
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int left, int right) {
        // 索引已经超过数组长度，已经遍历完成，说明后面的都是0
        if (right>=nums.length){
            return;
        }
        int cur = nums[right];
        for (int i = right; i > left; i--) {
            nums[i] = nums[i - 1];
        }
        nums[left] = cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
