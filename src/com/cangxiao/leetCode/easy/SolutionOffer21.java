package com.cangxiao.leetCode.easy;

import javax.swing.*;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class SolutionOffer21 {

    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (r > l) {
            while (r > l && (nums[l] & 1) == 1) {
                l++;
            }
            while (r > l && (nums[r] & 1) == 0) {
                r--;
            }
            swap(nums, l, r);
        }
        return nums;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
