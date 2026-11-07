package com.cangxiao.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: cangxiao
 * @Since: 5/11/2026
 * @description: 测试
 * 设计一个算法，找到数组中所有和为指定值的整数对。
 * 比如，Input: [1,2,3,4,5], 6
 * Output: [[1,5],[2,4]]
 */
public class Test {

    public static void main(String[] args) {
        Test a = new Test();
//        int[] nums = {1,2,3,4,5};
        int[] nums = {1,2,3,3,4,5};
        List<List<Integer>> result = a.count(nums, 6);
        System.out.println(result);

    }
    public List<List<Integer>> count(int[]  nums, int target){

        int length = nums.length;
        if (length < 2){
            return null;
        }
        Arrays.sort(nums);
        int i = 0, j = length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (i < j){
            int sum = nums[i] + nums[j];
            if (sum > target){
                j--;
            }
            if (sum < target){
                i++;
            }
            if (sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                i++;
                j--;
                result.add(list);
            }
        }
        return result;
    }
}
