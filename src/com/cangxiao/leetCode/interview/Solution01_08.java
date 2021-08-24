package com.cangxiao.leetCode.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc 面试题 01.08. 零矩阵
 */
public class Solution01_08 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> is = new HashSet<>();
        Set<Integer> js = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    is.add(i);
                    js.add(j);
                }
            }
        }
        for (Integer i : is) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : js) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int temp = -1;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    temp = i;
                    while (temp>0){
                        matrix[--temp][j] = 0;
                    }
                    temp = j;
                    set.add(j);
                    while (temp>0){
                        matrix[i][--temp] = 0;
                    }
                }
                if(temp!=-1){
                    matrix[i][j] = 0;
                }
                if(set.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution01_08 solution = new Solution01_08();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
