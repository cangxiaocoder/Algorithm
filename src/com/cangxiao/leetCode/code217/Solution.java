package com.cangxiao.leetCode.code217;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2021/8/5
 * @Desc 存在重复元素
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length<2) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public void sort(){

    }


}
