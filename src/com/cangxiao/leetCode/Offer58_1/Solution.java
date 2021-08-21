package com.cangxiao.leetCode.Offer58_1;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * @Author cangxiao
 * @Date 2021/8/18
 * @Desc 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Solution {

    public String reverseWords(String s) {
        if(s==null || s.equals(""))return "";

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if("".equals(strings[i])) continue;
            sb.append(strings[i]).append(" ");
        }

        return String.valueOf(sb).trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good   example"));
//        System.out.println(solution.reverseWords("    "));
    }
}
