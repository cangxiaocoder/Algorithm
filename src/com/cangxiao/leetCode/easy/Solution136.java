package com.cangxiao.leetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 136. 只出现一次的数字
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (int num : nums) {
            if (map.get(num)==1){
                return num;
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        if (nums.length==1)return nums[0];
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i==0 && nums[i]!=nums[i+1]){
                return nums[0];
            }
            if (i==nums.length-1 && nums[i]!=nums[i-1]){
                return nums[i];
            }
            if (i!=0 && nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 异或运算，位运算 相同为0. 不同为1
     * 1 0 1 1 0
     * 0 0 0 0 0
     * 1 0 1 1 0
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a^0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a^a=0。
     * 异或运算满足交换律和结合律，即 a^b^a=b^a^a=b^(a^a)=b^0=b。
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
