package com.cangxiao.leetCode.code9;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 -121 不是。
 *
 * @Author cangxiao
 * @Date 2021/8/21
 * @Desc 回文数
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] chars = String.valueOf(x).toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            if (chars[i++] != chars[j--]) return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {

        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber){
            int tem = x % 10;
            x = x /10;
            revertedNumber = revertedNumber * 10 + tem;
        }
        return revertedNumber == x || revertedNumber / 10 == x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome2(121));
    }
}
