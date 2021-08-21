package com.cangxiao.leetCode.Offer58_2;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @Author cangxiao
 * @Date 2021/8/21
 * @Desc 剑指 Offer 58 - II. 左旋转字符串
 */
public class Solution {

    public String reverseLeftWords(String s, int n) {
        if(n > s.length()) return s;
        return String.valueOf(s.toCharArray(),n,s.length()-n)+String.valueOf(s.toCharArray(),0,n);
    }

    public String reverseLeftWords2(String s, int n) {
        if(n > s.length()) return s;
        StringBuilder sb= new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
        System.out.println(solution.reverseLeftWords("abcdefg", 0));
        System.out.println(solution.reverseLeftWords("abcdefg", 8));
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
        System.out.println(solution.reverseLeftWords2("abcdefg", 2));
        System.out.println(solution.reverseLeftWords2("abcdefg", 0));
        System.out.println(solution.reverseLeftWords2("abcdefg", 8));
        System.out.println(solution.reverseLeftWords2("abcdefg", 2));
        char[] chars = new char[]{'2','a','b','c'};
        System.out.println(String.valueOf(chars,0,2));
        System.out.println(String.valueOf(chars,2,2));
    }
}
