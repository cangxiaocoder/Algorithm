package com.cangxiao.slidingWin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: cangxiao
 * @Since: 6/11/2026
 * @description: 3. 无重复字符的最长子串
 */
public class MaxSunString {

    public static void main(String[] args) {
//        String str = "abcabcbb";
//        String str = "pwwkew";
//        String str = "s";
//        String str = "mq";
        String str = "eea";
        int length = new MaxSunString().lengthOfLongestSubstring(str);
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        while (right < length) {
            while (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int left = 0, right = 0;
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        while (right < length) {
            while (map.containsKey(chars[right])) {
                map.remove(chars[left]);
                left++;
            }
            map.put(chars[right], right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
