package com.cangxiao.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 剑指 Offer 03. 数组中重复的数字
 */
public class SolutionOffer03 {

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                return num;
            }
            map.put(num,1);
        }
        return -1;
    }
}
