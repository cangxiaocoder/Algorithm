package com.cangxiao.offer;


/**
 * @Author cangxiao
 * @Date 2022/2/21
 * @Desc 剑指 Offer 04. 二维数组中的查找
 * 从右上角往左下角走，
 * 1. 如果 target > matrix[row][col]，则往下走，matrix[row][col]时row行最大值，col列最小值 所以target一定在row行之下
 * 2. 如果 target < matrix[row][col]，则往左走，matrix[row][col]时row行最大值，col列最小值 所以target一定在col列之左
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int row = 0; int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] < target){
                row++;
            }else if (matrix[row][col] > target){
                col--;
            }else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Offer04 offer04 = new Offer04();

        int[][] array = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}

        };
        boolean flag = offer04.findNumberIn2DArray(array, 14);
        System.out.println("flag = " + flag);
    }
}