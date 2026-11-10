package com.cangxiao.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cangxiao
 * @Since: 8/11/2026
 * @description: 只出现一次的数字
 * 3，只出现一次的数字
 * 某个元素只出现一次以外，其余每个元素均出现两次，找出1次的
 * 输入：nums = [2,2,1]
 * 输出：1
 */
public class OnceNum {

    public static void main(String[] args) {
        OnceNum onceNum = new OnceNum();
        int[] nums = {2,2,1,3,4,4,3,5,5};
        System.out.println(onceNum.searchOnceNum(nums));
    }

    private Integer searchOnceNum(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
    }
}
