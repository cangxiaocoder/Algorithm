package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/21
 * @Desc 77. 组合
 */
public class Solution77_2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) return result;
        backtrack(n,k, 1,new ArrayList<Integer>());
        return result;
    }


    private void backtrack(int n, int k, int step, List<Integer> temp) {
        if (temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(step>n){
            return;
        }
        backtrack(n,k,step+1,temp);
        temp.add(step);
        backtrack(n,k,step+1,temp);
        temp.remove(temp.size()-1);
    }
}
