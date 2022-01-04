package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cangxiao
 * @Date 2022/1/2
 * @Desc 47. 全排列 II
 */
public class Solution47 {
    Set<List<Integer>> resultSet = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums,0);
        return new ArrayList<>(resultSet);
    }

    private void backtrack(int[] nums, int k) {
        if (nums.length == k){
            List<Integer> temp = new ArrayList<>();
            for (Integer i : path) {
                temp.add(nums[i]);
            }
            resultSet.add(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(i)){
                continue;
            }
            path.add(i);
            backtrack(nums,k+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}
