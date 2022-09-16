package com.cangxiao.array;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/9/13
 * @Desc
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int s1_i = 0;
        int s1_j = 0;

        while (length > 1) {
            //通过第一个元素确定四个角元素位置
            int s2_i = s1_i;
            int s2_j = s1_j + length - 1;
            int s3_i = s1_i + length - 1;
            int s3_j = s1_j + length - 1;
            int s4_i = s1_i + length - 1;
            int s4_j = s1_j;
            //最后一个元素不需要旋转
            for (int k = 0; k <= length - 2; k++) {
                //第一个元素向右移动
                int p1_i = s1_i;
                int p1_j = s1_j + k;
                //第二个元素向下移动
                int p2_i = s2_i + k;
                int p2_j = s2_j;
                //第三个元素向左移动
                int p3_i = s3_i;
                int p3_j = s3_j - k;
                //第一个元素向上移动
                int p4_i = s4_i - k;
                int p4_j = s4_j;
                System.out.print(matrix[p1_i][p1_j]);
                System.out.print("  ");
                System.out.println(matrix[p2_i][p2_j]);
                System.out.print(matrix[p3_i][p3_j]);
                System.out.print("  ");
                System.out.println(matrix[p4_i][p4_j]);
                //每次交换这四个位置的元素
                swap(matrix, p1_i, p1_j, p2_i, p2_j, p3_i, p3_j, p4_i, p4_j);
            }
            //进入第二层
            s1_i ++;
            s1_j ++;
            length -= 2;
        }

    }

    private void swap(int[][] matrix, int p1_i, int p1_j, int p2_i, int p2_j, int p3_i, int p3_j, int p4_i, int p4_j) {
        int temp = matrix[p1_i][p1_j];
        matrix[p1_i][p1_j] = matrix[p4_i][p4_j];
        matrix[p4_i][p4_j] = matrix[p3_i][p3_j];
        matrix[p3_i][p3_j] = matrix[p2_i][p2_j];
        matrix[p2_i][p2_j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix);
        System.out.println("matrix = " + Arrays.deepToString(matrix));
    }
}
