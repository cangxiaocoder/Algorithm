package com.cangxiao.leetCode.code1;

import sun.net.idn.Punycode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/8/7
 * @Desc 两数之和
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    /**
     * 暴力破解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(temp==nums[j] && i!=j){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,4,15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 6)));
        System.out.println(Arrays.toString(solution.twoSum2(nums, 6)));
    }
}