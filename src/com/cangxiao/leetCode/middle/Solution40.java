package com.cangxiao.leetCode.middle;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/1/2
 * @Desc 40. 组合总和 II
 */
public class Solution40 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int candidate : candidates) {
            map.put(candidate,map.getOrDefault(candidate,0)+1);
        }
        int[] uniqueNums = new int[map.size()];
        int[] counts = new int[map.size()];
        int k = 0;
        for (int candidate : candidates) {
            if (map.containsKey(candidate)){
                uniqueNums[k] = candidate;
                counts[k++] = map.get(candidate);
                map.remove(candidate);
            }
        }
        backtrack(target, 0 ,uniqueNums,counts);
        return result;
    }

    private void backtrack(int target, int k, int[] uniqueNums, int[] counts) {
        if (target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //如果target<0说明当前组合不符合要求，直接退出
        if (target < 0 || k==uniqueNums.length){
            return;
        }
        for (int count = 0; count <= counts[k]; count++) {
            for (int i = 0; i < count; i++) {
                path.add(uniqueNums[k]);
            }
            backtrack(target-count*uniqueNums[k],k+1,uniqueNums,counts);
            for (int i = 0; i < count; i++) {
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution40 solution = new Solution40();
//        List<List<Integer>> result = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> result = solution.combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27);
        System.out.println("result = " + result);
    }
}
