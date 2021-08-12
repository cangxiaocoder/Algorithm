package com.cangxiao.leetCode.code118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Author cangxiao
 * @Date 2021/8/12
 * @Desc 杨辉三角
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>();
        List<Integer> list = null;
        if(numRows >= 1){
            list = new ArrayList<>();
            list.add(1);
            triangleList.add(list);
            list = null;
        }

        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(0,1);
            for (int j = 1; j < i; j++) {
                List<Integer> integerList = triangleList.get(i - 1);
                list.add(j,integerList.get(j-1)+integerList.get(j));
            }
            list.add(i,1);
            triangleList.add(list);
            list = null;
        }
        return triangleList;
    }

    private static void print(List<List<Integer>> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
                System.out.print(",");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangleList = solution.generate(3);
        print(triangleList);

    }
}
