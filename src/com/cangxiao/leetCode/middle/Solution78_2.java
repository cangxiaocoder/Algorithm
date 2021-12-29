package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/26
 * @Desc 78. 子集
 */
public class Solution78_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0) return result;
        backtrack(nums,0,result);
        return result;
    }
    List<Integer> temp = new ArrayList<>();
    private void backtrack(int[] nums,int step,List<List<Integer>> result) {
        if (nums.length==step){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[step]);
        backtrack(nums,step+1,result);
        temp.remove(temp.size()-1);
        backtrack(nums,step+1,result);
    }

    public static void main(String[] args) {
        Solution78_2 solution = new Solution78_2();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
