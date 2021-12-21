package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/21
 * @Desc 77. 组合
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) return result;
        backtrack(result, 1, n, k);
        return result;
    }

    List<Integer> temp = new ArrayList<>();

    /**
     * 例：
     * 范围为1~n,k=2; 第一次决策值为1，temp.add(1) temp = {1}
     * 第二次决策值为cur = cur+1 = 2;temp = {1,2}
     * 移除第二次的决策值 temp = {1}
     * 重新决策当前位置temp.add(cur = cur+1) ,此时cur = 3;temp = {1,3}
     *
     */
    private void backtrack(List<List<Integer>> result, int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //决策第一位
        temp.add(cur);
        //决策下一位
        backtrack(result, cur + 1, n, k);
        //移除当前位置的元素，重新决策
        temp.remove(temp.size() - 1);
        //重新决策当前位置的值，
        backtrack(result, cur + 1, n, k);

    }
}
