package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/9/25
 * @Desc 74. 搜索二维矩阵
 */
public class Solution74 {
    /**
     * 先确定在那一层
     * 再确定在那个位置
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int low = 0;
        int high = m;
        int left = 0;
        int right = n;
        //确定层级
        while (low<=high){
            int i = low + (high - low) / 2;
            if (matrix[i][0]<= target && target <= matrix[i][n]){
                //确定位置
                while (left<=right){
                    int j = left + (right - left) / 2;
                    if (matrix[i][j] == target){
                        return true;
                    }
                    if (matrix[i][j]<target){
                        left = j + 1;
                    }else {
                        right = j - 1;
                    }
                }
                return false;
            }
            if (matrix[i][0] > target){
                high = i -1;
            }else {
                low = i + 1;
            }
        }
        return false;
    }
}
