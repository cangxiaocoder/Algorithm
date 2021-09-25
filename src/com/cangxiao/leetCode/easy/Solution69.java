package com.cangxiao.leetCode.easy;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * @Author cangxiao
 * @Date 2021/9/25
 * @Desc 69. x 的平方根
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x==0) return 0;
        int low = 1;
        int high = x;
        while (low <= high) {
            //使用除法代替乘法避免越界
            int mid = low + (high - low) / 2;
            if (mid <=x / mid && (mid+1)>x/(mid+1)){
                return mid;
            }
            if (mid < x / mid){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        System.out.println(solution.mySqrt(2147395600));
    }
}
