package com.cangxiao.array;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/9/18
 * @Desc 对角线遍历
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int i = 0;
        int j = 0;
        int k = 0;
        //对角线方向的次数
        int count = 0;
        while (k < m * n) {
            //奇数反向遍历，
            //偶数正向遍历
            if ((count & 1) == 0) {
                while (i >= 0 && j < n) {
                    result[k++] = mat[i][j];
                    //右上， i减小，j增大
                    i--;
                    j++;
                }
                /*
                    如果i越界，j还未越界，如图：则只需要i+1,移动指针到2的位置
                        {i,j}
                    1    2    3
                    4    5    6
                    7    8    9

                    如果i越界，j也越界，如图：则只需要i+2、 j-1,才能移动指针到6的位置
                                {i,j}
                    1    2    3
                    4    5    6
                    7    8    9
                 */
                if (j < n){
                    i++;
                }else {
                    i+=2;
                    j--;
                }
            } else {
                while (i < m && j >= 0) {
                    result[k++] = mat[i][j];
                    i++;
                    j--;
                }
                if (i < m){
                    j++;
                }else {
                    j+=2;
                    i--;
                }
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 0, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[] result = findDiagonalOrder.findDiagonalOrder(matrix);
        System.out.println("result = " + Arrays.toString(result));

    }
}
