package com.cangxiao.leetCode.easy;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 75. 颜色分类
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        sort(nums,0,nums.length -1);
    }

    private void sort(int[] nums,int p , int q){
        if (p<q){
            int index = partition(nums,p, q);
            sort(nums, p, index);
            sort(nums,index+1, q);
        }

    }

    private int partition(int[] nums,int p , int q){
        int value = nums[p];

        while (p<q){
            while (p<q && value <= nums[q]){
                q--;
            }
            nums[p] = nums[q];
            while (p<q && value > nums[p]){
                p++;
            }
            nums[q] = nums[p];
        }
        nums[p] = value;
        return p;
    }

    public static void main(String[] args) {
        Solution75 solution = new Solution75();
        int[] arr = new int[]{1,1,1};
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
