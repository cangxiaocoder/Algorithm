package com.cangxiao.leetCode.code566;

import java.util.ArrayList;
import java.util.List;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * @Author cangxiao
 * @Date 2021/8/12
 * @Desc
 */
public class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int len = mat.length;
        int high = mat[0].length;
        //不等说明不合理
        if (len * high != r * c) {
            return mat;
        }
        int[][] array = new int[r][c];
        int k = 0, l = 0;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                //当l大于等于c, 则需要进入下一行了
                if (l >= c) {
                    l = 0;
                    k++;
                }
                if (k >= r) {
                    return mat;
                }
                array[k][l++] = anInt;
            }
        }
        return array;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] array = new int[r][c];
        /*
         * 二维数组映射成一位数组，i/c的值即为当前元素的高度，i%c 的值即为当前元素的长度
         * r = 1 c = 4 mat.length =2  mat[0].length = 2;
         * 当i = 0时
         * array[0][0] = mat[0][0]
         * 当i = 1时
         * array[0][1] = mat[0][1]
         * 当i = 2时
         * array[0][2] = mat[1][0]
         */
        for (int i = 0; i < mat.length * mat[0].length; i++) {

            array[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
        }
        return array;
    }

    public static void main(String[] args) {
       /* int[][] mat = new int[][]{{1, 2, 3, 4}};
//        int[][] mat = new int[][]{{1, 2}};
        Solution solution = new Solution();
        int[][] arr = solution.matrixReshape2(mat, 1, 4);
        print(arr);
        System.out.println(0 % 4);*/
        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        list.add(0,2);
        System.out.println(list);
    }

    private static void print(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(",");
            }
            System.out.print("]");
        }
        System.out.print("]");

    }
}
