package com.cangxiao.leetCode.interview;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 面试题 01.02. 判定是否互为字符重排
 */
public class Solution01_02 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : chars1) {
            c1[c-'a']++;
        }
        for (char c : chars2) {
            c2[c-'a']++;
        }
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {

    }
}
