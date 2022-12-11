package com.cangxiao.leetCode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0; //记录最长子串长度
        int left = 0; //子串起始位置
        for (int i = 0; i < s.length(); i++) {
            //如果map中存在则说明遇到重复字符 重复字符为s.charAt(i)
            if (map.containsKey(s.charAt(i))){
                //map.get(s.charAt(i)) 找到重复字符索引，然后 +1，
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left +1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.print( solution3.lengthOfLongestSubstring("pwwkew"));
    }
}