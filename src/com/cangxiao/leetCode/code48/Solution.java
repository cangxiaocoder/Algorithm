package com.cangxiao.leetCode.code48;

import java.nio.file.NotLinkException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2021/8/23
 * @Desc 48. 旋转图像
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int s1_i = 0;
        int s1_j = 0;
        while (length>1){

            int s2_i = s1_i;
            int s2_j = s1_j + length - 1;
            int s3_i = s1_i + length - 1;
            int s3_j = s1_j + length - 1 ;
            int s4_i = s1_i + length - 1;
            int s4_j = s1_j;
            //最后一个元素不需要再旋转了
            for (int k = 0; k <= length-2; k++) {
                //第一个节点向右走，i不变， j+k;
                int p1_i = s1_i;
                int p1_j = s1_j + k;
                //第二个节点向下走，i+k， j不变;
                int p2_i = s2_i + k;
                int p2_j = s2_j;
                //第三个节点向左走，i不变， j-k;
                int p3_i = s3_i;
                int p3_j = s3_j - k;
                //第四个节点向上走，i-k， j不变;
                int p4_i = s4_i - k;
                int p4_j = s4_j;
                System.out.print(matrix[p1_i][p1_j]);
                System.out.print("  ");
                System.out.println(matrix[p2_i][p2_j]);
                System.out.print(matrix[p3_i][p3_j]);
                System.out.print("  ");
                System.out.println(matrix[p4_i][p4_j]);
                swap(matrix,p1_i,p1_j,p2_i,p2_j,p3_i,p3_j,p4_i,p4_j);
            }

            s1_i++;
            s1_j++;
            length = length -2;
        }
    }

    /**
     * 将四边的元素旋转90度
     * @param matrix
     * @param p1_i
     * @param p1_j
     * @param p2_i
     * @param p2_j
     * @param p3_i
     * @param p3_j
     * @param p4_i
     * @param p4_j
     */
    private void swap(int[][] matrix,int p1_i,int p1_j,int p2_i,int p2_j,int p3_i,int p3_j,int p4_i,int p4_j){
        int temp = matrix[p1_i][p1_j];
        matrix[p1_i][p1_j] = matrix[p4_i][p4_j];
        matrix[p4_i][p4_j] = matrix[p3_i][p3_j];
        matrix[p3_i][p3_j] = matrix[p2_i][p2_j];
        matrix[p2_i][p2_j] = temp;
    }

    public static void main(String[] args) {

        Solution solution =new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        solution.rotate(matrix);
//        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
