package com.cangxiao.array;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/9/18
 * @Desc 零矩阵
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int temp = -1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //横向设为 0；
                    temp = i;
                    while (temp > 0) {
                        matrix[--temp][j] = 0;
                    }
                    //纵向设为 0
                    temp = j;
                    set.add(j);
                    while (temp > 0) {
                        matrix[i][--temp] = 0;
                    }
                }
                //继续遍历i 的行，将整行设为0
                if (temp != -1) {
                    matrix[i][j] = 0;
                }
                //遍历到{i,j}的位置，set包含j, 说明{i,j}这一列都应设为0
                if (set.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 0, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("matrix = " + Arrays.toString(matrix[i]));
        }
    }

}
