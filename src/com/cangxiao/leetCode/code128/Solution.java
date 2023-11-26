package com.cangxiao.leetCode.code128;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2023/11/24
 * @Desc 128. 最长连续序列
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (map.containsKey(nums[i])){
                continue;
            }
            // 每次遍历到新数字时，去hashMap中寻找比它小1的数字和比它大1的数字对应的长度，记为min和max。
            Integer max = map.getOrDefault(nums[i]+1,0);
            Integer min = map.getOrDefault(nums[i]-1,0);
            int len = max + min + 1;
            if (max==0 && min==0){
                // max和min都为0说明不存在序列数据，只有当前值，长度为1
                map.put(nums[i],1);
            }else if (max == 0){
                // max为0 map中不存在上界值，但存在下界值，更新长度
                map.put(nums[i],len);
                map.put(nums[i] - min,len);
            }else if (min==0){
                // min为0 map中不存在下界值，但存在上界值，更新长度
                map.put(nums[i] + max,len);
                map.put(nums[i],len);
            }else {
                // 都不为0 map中不存在下界值和下界值，更新长度
                map.put(nums[i] + max,len);
                map.put(nums[i] - min,len);
                map.put(nums[i],len);
            }
            // 若有多个序列，取序列长度最长的序列
            result = Math.max(result, len);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
