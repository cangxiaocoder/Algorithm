package com.cangxiao.leetCode.middle;

import java.awt.image.IndexColorModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/1/2
 * @Desc 216. 组合总和 III
 */
public class Solution216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, 1);
        return result;
    }

    private void backtrack(int target, int k, int index) {
        if (target==0 && path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        if (target<0 || index>9){
            return;
        }
        backtrack(target, k, index+1);
        path.add(index);
        backtrack(target-index, k, index+1);
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        Solution216 solution = new Solution216();
        List<List<Integer>> result = solution.combinationSum3(3, 7);
        System.out.println("result = " + result);
    }
}
