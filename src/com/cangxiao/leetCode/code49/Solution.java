package com.cangxiao.leetCode.code49;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2023/11/26
 * @Desc 49. 字母异位词分组
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);

        }
        map.forEach((key, value) -> result.add(value));
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}
