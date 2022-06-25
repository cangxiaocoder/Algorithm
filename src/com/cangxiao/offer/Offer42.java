package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/6/25
 * @Desc 剑指 Offer 42. 连续子数组的最大和
 */
public class Offer42 {
    /**
     *
     * @param nums
     * @return
     */

    public int maxSubArray(int[] nums) {
        int pre = 0; int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }

}
