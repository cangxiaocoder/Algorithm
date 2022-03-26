package com.cangxiao.offer;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/3/26
 * @Desc 剑指 Offer 29. 顺时针打印矩阵
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
        int length = right*bottom;
        int[] result = new int[length];
        int index = 0;
        while (left<right && top < bottom){
            //从左到右
            for (int i = left; i < right; i++) {
                result[index++] = matrix[top][i];
            }
            //从上到下，第一个值在从左到右时已经加入结果集中
            for (int i = top +1; i < bottom; i++) {
                result[index++] = matrix[i][right - 1];
            }

            if (left < right - 1 && top < bottom - 1){
                //从右到左 第一个值在从上到下时已经加入结果集中
                for (int i = right - 1 - 1; i >= left; i--) {
                    result[index++] = matrix[bottom - 1][i];
                }
                //从下到上
                for (int i = bottom - 1 - 1; i > top; i--) {
                    result[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};

        Offer29 offer29 = new Offer29();
        int[] result = offer29.spiralOrder(matrix);
        System.out.println("result = " + Arrays.toString(result));
    }
}
