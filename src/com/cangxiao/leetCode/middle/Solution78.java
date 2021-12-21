package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/21
 * @Desc 78. 子集
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0) return result;
        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums,0,i,result);
        }
        return result;
    }
    List<Integer> temp = new ArrayList<>();
    private void backtrack(int[] nums,int step, int k,List<List<Integer>> result) {
        if (temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        if (step>=nums.length)return;
        temp.add(nums[step]);
        backtrack(nums,step+1,k,result);
        temp.remove(temp.size()-1);
        backtrack(nums,step+1,k,result);
    }

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
