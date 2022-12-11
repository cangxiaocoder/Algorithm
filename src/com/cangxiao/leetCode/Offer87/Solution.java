package com.cangxiao.leetCode.Offer87;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 * 输入: "42"
 * 输出: 42
 *
 * @Author cangxiao
 * @Date 2021/8/21
 * @Desc 剑指 Offer 67. 把字符串转换成整数
 */
public class Solution {

    public int strToInt(String str) {
        int version = 0;
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (version == 0 && str.charAt(i) == ' ') {
                continue;
            }
            if (str.charAt(i) == '-' && version == 0) {
                version = -1;
                continue;
            }
            if (str.charAt(i) == '+' && version == 0) {
                version = 1;
                continue;
            }
            if ('0' > str.charAt(i) || str.charAt(i) > '9') {
                break;
            }
            version = version == -1 ? -1 : 1;
            if (num >= Integer.MAX_VALUE/10) {
                return version >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (str.charAt(i)-'0');
        }
        if (version != 1 && version != -1) return 0;
        return version == 1 ? (int) num : -(int) num;

    }
    public int strToInt2(String str) {
        int version = 0;
        long num = 0;int j = 0;
        while (j < str.length()&&str.charAt(j) == ' ') {
            j++;
        }
        for (int i = j; i < str.length(); i++) {

            if (str.charAt(i) == '-' && version == 0) {
                version = -1;
                continue;
            }
            if (str.charAt(i) == '+' && version == 0) {
                version = 1;
                continue;
            }
            if ('0' > str.charAt(i) || str.charAt(i) > '9') {
                break;
            }
            version = version == -1 ? -1 : 1;
            if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && str.charAt(i)>'7')) {
                return version >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (str.charAt(i)-'0');
        }
        if (version != 1 && version != -1) return 0;
        return version == 1 ? (int) num : -(int) num;

    }

    public int strToInt3(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

    

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt3("-2147483648"));
        System.out.println(solution.strToInt2("    "));
//        System.out.println(solution.strToInt("-9128347233"));
//        System.out.println(solution.strToInt("18446744073709551617"));
//        System.out.println(solution.strToInt("-18446744073709551617"));
//        System.out.println(solution.strToInt("9223372036854775808"));
//        System.out.println(solution.strToInt("-234"));
//        System.out.println(solution.strToInt("   +0 123"));
//        System.out.println(solution.strToInt("  -0012a42"));
//        System.out.println(solution.strToInt("   -42"));
//        System.out.println(solution.strToInt("   "));
//        System.out.println(solution.strToInt(""));
//        System.out.println(solution.strToInt("  +42"));
//        System.out.println(solution.strToInt("-042a"));
//        System.out.println(solution.strToInt("- a"));
//        System.out.println(solution.strToInt("+-2"));
//        System.out.println(solution.strToInt("-91283472332"));
    }
}
