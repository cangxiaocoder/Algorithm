package com.cangxiao.leetCode.middle;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/1/2
 * @Desc 47. 全排列 II
 */
public class Solution47_2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        /*
            将包含重复元素的问题变成无重复元素
         */
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int size = map.size();
        int[] uniqueNums = new int[size];
        int[] counts = new int[size];
        int index = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                uniqueNums[index] = num;
                counts[index++] = map.get(num);
                map.remove(num);
            }
        }

        backtrack(uniqueNums,counts,0,nums.length,path);
        return result;
    }

    private void backtrack(int[] uniqueNums, int[] counts, int k, int length, List<Integer> path) {
        if (k==length){
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < uniqueNums.length; i++) {
            //counts[i]==0,说明此元素已经被用完了
            if (counts[i]==0) continue;
            path.add(uniqueNums[i]);
            //添加了这个元素，这个元素的个数减 1；
            counts[i]--;
            backtrack(uniqueNums,counts,k+1,length,path);
            path.remove(path.size()-1);
            //移除了这个元素重新决策，这个元素的个数重新加 1；
            counts[i]++;
        }
    }

    public static void main(String[] args) {
        Solution47_2 solution = new Solution47_2();
        List<List<Integer>> result = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println("result = " + result);
    }

}
