package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/1/2
 * @Desc 39. 组合总和
 * 每个元素可以选择多少个，
 */
public class Solution39 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int k,List<Integer> path) {
        //每选择了一个元素就更新目标值，当目标值为0说明选择的组合满足要求
        if (target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //决策完所有步骤,此时target依然不为0，
        if (k==candidates.length){
           return;
        }
        /*
            target/candidates[i],当前元素最多可以选择多少个，如目标值是7，元素值2 最多可以选择3个
         */
        for (int i = 0; i <= target/candidates[k]; i++) {
            //当前元素选择多少个
            for (int j = 0; j < i; j++) {
                path.add(candidates[k]);
            }
            //当前元素candidates[k]选择了i次，更新目标值
            backtrack(candidates,target - i*candidates[k],k+1,path);
            //当前元素插入了多少个就移除多少个
            for (int j = 0; j < i; j++) {
                path.remove(path.size()-1);
            }
        }

    }
}
