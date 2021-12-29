package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/26
 * @Desc 46. 全排列
 */
public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        backtrack(nums, temp.size());
        return result;
    }

    private void backtrack(int[] nums, int index) {
        System.out.println(temp);
        //决策完所有步骤
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        /*if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }*/
        for (int num : nums) {
            //如果此元素已经被加入到集合则跳过
            if (temp.contains(num)) {
                continue;
            }
            temp.add(num);
            //决策下一个元素
            backtrack(nums, index + 1);
            //移除最后一个元素重新决策
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        System.out.println("result = " + result);
    }
}
