package com.cangxiao.leetCode.code53;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * @Author cangxiao
 * @Date 2021/8/5
 * @Desc 最大子序和
 */
public class Solution {

    /**
     * 若当前值与当前值之前的值相加比当前值小，则说明前面相加的值一定不是最大值，则直接舍弃
     * 如 -2+1<1 则舍弃-2；
     *  1+(-3）>-3 则继续累加
     *  1+(-3)+4 < 4则舍弃1+(-3)
     *  maxSub ：记录出现的最大值；
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int preSum = nums[0];
        int maxSub = nums[0];
        for (int num : nums) {
            preSum = Math.max(preSum+num,num);
            maxSub = Math.max(preSum,maxSub);
        }
        return maxSub;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = new int[]{-2,-1};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
