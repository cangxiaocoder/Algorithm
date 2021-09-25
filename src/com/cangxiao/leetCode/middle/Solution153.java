package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/9/25
 * @Desc 153. 寻找旋转排序数组中的最小值
 */
public class Solution153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while (left<=right){
            if (left==right){
                return nums[left];
            }
            int mid = left+(right-left)/2;
            if (mid==0 && nums[mid]<nums[right] ||
                mid!=0&&nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if (nums[mid]>nums[right]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        return -1;
    }
}
