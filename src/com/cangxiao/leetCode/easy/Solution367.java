package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/9/25
 * @Desc 367. 有效的完全平方数
 */
public class Solution367 {

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low<= high){

            int mid = low + (high - low) / 2;
            if (mid * mid == num){
                return true;
            }
            //不使用 mid * mid 避免数字太大超过int最大值
            if (mid  < num /mid){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution367 solution = new Solution367();
        System.out.println(solution.isPerfectSquare(2147483647));
    }
}
