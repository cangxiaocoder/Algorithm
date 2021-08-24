package com.cangxiao.leetCode.code16;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Author cangxiao
 * @Date 2021/8/21
 * @Desc 删除有序数组中的重复项
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                len--;
            }
        }
        return len;
    }

    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int i = 0, j = 1;
        while (j < len){
            if (nums[i]!=nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(solution.removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4}));
        System.out.println(solution.removeDuplicates2(new int[]{}));
        System.out.println(solution.removeDuplicates2(new int[]{0,1,2,3,4}));
        System.out.println(solution.removeDuplicates2(new int[]{1,1,2}));
    }
}
