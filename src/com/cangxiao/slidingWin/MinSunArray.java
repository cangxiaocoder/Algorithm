package com.cangxiao.slidingWin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cangxiao
 * @Since: 1/11/2026
 * @description: 209. 长度最小的子数组
 */
public class MinSunArray {

    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0, fast = 0, length = nums.length;
        int minLen = 0;
        int sum = nums[slow];
        while (fast < length) {
            if (nums[fast] >= target) {
                minLen = 1;
                return minLen;
            }
            while (sum < target && ++fast < length) {
                sum += nums[fast];
            }
            while (slow <= fast && sum >= target) {
                if (minLen == 0) {
                    minLen = fast - slow + 1;
                } else {
                    minLen = Math.min(minLen, fast - slow + 1);
                }
                sum -= nums[slow++];
            }

        }
        return minLen;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0,  length = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
            while (sum >= target){
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 2, 4, 3};
//        System.out.println(new MinSunArray().minSubArrayLen(7, nums));
//        int[] nums = {1,4,4,5};
//        System.out.println(new MinSunArray().minSubArrayLen(5, nums));
//        int[] nums = {1,1,1,1,3,4};
//        System.out.println(new MinSunArray().minSubArrayLen(7, nums));
//        int[] nums = {8};
//        System.out.println(new MinSunArray().minSubArrayLen(7, nums));
//        int[] nums = {1,2,3,4,5};
//        System.out.println(new MinSunArray().minSubArrayLen(11, nums));
//        int[] nums = {1,2,3,4,5};
//        System.out.println(new MinSunArray().minSubArrayLen(15, nums));

    }
}
