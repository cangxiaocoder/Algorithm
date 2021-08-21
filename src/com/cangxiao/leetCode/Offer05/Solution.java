package com.cangxiao.leetCode.Offer05;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @Author cangxiao
 * @Date 2021/8/21
 * @Desc 剑指 Offer 05. 替换空格
 */
public class Solution {

    public String replaceSpace(String s) {
        int len = s.length();
        char[] chars = new char[len * 3];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            }else {
                chars[size++] = s.charAt(i);
            }
        }
        return String.valueOf(chars,0, size);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
        System.out.println(solution.replaceSpace(" "));
        System.out.println(solution.replaceSpace("We"));
    }
}
