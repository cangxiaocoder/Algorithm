package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/12/21
 * @Desc 90. 子集
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 为了避免重复，同一个元素只能取一次，将一个元素放与不放的问题改为放几个的问题
 * 如 元素1只有有个，可以选择放0个/1个
 *    元素2右两个，可以选择放0个/1个/2两个。
 *    将两者组合起来
 *    当元素1放0个元素2放0个集合为空 {}
 *    当元素1放0个元素2放1个集合为空 {2}
 *    当元素1放0个元素2放2个集合为空 {2，2}
 *    当元素1放1个元素2放0个集合为空 {1}
 *    当元素1放1个元素2放1个集合为空 {1，2}
 *    当元素1放1个元素2放2个集合为空 {1，2，2}
 *    result = {{},{2},{2,2}{1},{1,2},{1,2,2}}
 */
public class Solution90 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
                continue;
            }
            map.put(num,1);
        }
        int n = map.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int num : nums) {
            if (map.containsKey(num)){
                uniqueNums[k] = num;
                counts[k++] = map.get(num);
                map.remove(num);
            }
        }
        backtrack(uniqueNums,counts,0,new ArrayList<>());
        return result;
    }

    private void backtrack(int[] uniqueNums,int[] counts,int k ,List<Integer> temp) {
        if (k==uniqueNums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        /*
         * counts[k] 表示索引k的元素的个数
         * count = 0时表示放0个元素
         * count = 1时表示放1个元素
         * ...
         */
        for (int count = 0; count <= counts[k]; count++) {
            //当前元素可以选择放几个,最多可以放counts[k]个
            for (int i = 0; i < count; i++) {
                temp.add(uniqueNums[k]);
            }
            //决策下一个元素
            backtrack(uniqueNums,counts,k+1,temp);
            //前面放了多少个，现在移除多少个，然后重新决策
            for (int i = 0; i < count; i++) {
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        List<List<Integer>> subsets = solution.subsetsWithDup(new int[]{1, 2, 2, 2, 1});
        System.out.println(subsets);
    }
}
