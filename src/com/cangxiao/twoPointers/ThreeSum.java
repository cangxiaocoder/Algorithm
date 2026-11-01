package com.cangxiao.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: cangxiao
 * @Since: 1/11/2026
 * @description: 15. 三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                // nums[i] 则 nums[k]nums[j] 肯定都大于零
                break;
            }
            if (i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int k = i + 1, j = length - 1;
            while (k < j){
                int sum = nums[i] + nums[k] + nums[j];
                if (sum < 0){
                    while (k < j && nums[k] == nums[++k]);
                }else if (sum > 0){
                    while (k < j && nums[j] == nums[--j]);
                }else {
                    result.add(List.of(nums[i], nums[k], nums[j]));
                    while (k < j && nums[k] == nums[++k]);
                    while (k < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,1,1};
//        int[] nums = {0,0,0};
//        int[] nums = {0, 0, 0, 0};
//        System.out.println(threeSum.threeSum2(nums));
        System.out.println(threeSum.threeSum(nums));
    }
}
