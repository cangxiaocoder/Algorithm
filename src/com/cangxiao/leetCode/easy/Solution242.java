package com.cangxiao.leetCode.easy;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 242. 有效的字母异位词
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
