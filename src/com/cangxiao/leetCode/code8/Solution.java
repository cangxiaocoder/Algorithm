package com.cangxiao.leetCode.code8;

/**
 * @Author cangxiao
 * @Date 2023/11/24
 * @Desc 字符串转换整数 (atoi)
 */
public class Solution {

    public int myAtoi(String s) {
        int i = 0;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(Integer.MAX_VALUE).length();
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (s.charAt(i) == '-') {
                flag = -1;
                i++;
            }
            if (flag==0 && s.charAt(i) == '+') {
                flag = 1;
                i++;
            }

            while (i < s.length()) {
                // 数字后面出现非数字结束
                if (!Character.isDigit(s.charAt(i))) {
                    break;
                }
                // 去掉前导0
                if (s.charAt(i) == '0' && sb.length() == 0) {
                    i++;
                    continue;
                }
                sb.append(s.charAt(i));
                i++;
                // 超过int最大值结束
                if (sb.length() > length) {
                    break;
                }
            }
            break;
        }
        if (sb.length()==0){
            return 0;
        }
        long num = Long.parseLong(sb.toString());
        if (flag == 0 || flag == 1) {
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) num;
            }
        } else {
            if (num - 1 > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return -(int) num;
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(new Solution().myAtoi("  0000000000012345678"));
//        System.out.println(new Solution().myAtoi("   -42"));
//        System.out.println(new Solution().myAtoi("21474836460"));
//        System.out.println(new Solution().myAtoi("4193 with words"));
        System.out.println(new Solution().myAtoi("+-42"));
        System.out.println(new Solution().myAtoi("-+42"));
//        System.out.println(new Solution().myAtoi("-12345678987654321"));
//        System.out.println(new Solution().myAtoi("12345678987654321"));
    }
}
